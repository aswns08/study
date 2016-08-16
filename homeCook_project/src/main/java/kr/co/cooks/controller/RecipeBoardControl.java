package kr.co.cooks.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.RecipeBoardService;
import kr.co.cooks.vo.RecipeBoardUserVO;
import kr.co.cooks.vo.RecipeBoardVO;
import kr.co.cooks.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeBoardControl {
	@Autowired RecipeBoardService recipeService ;
	
	RecipeBoardVO recipeVO;
	RecipeBoardUserVO recipeUserVO;
	static final int PAGE_DEFAULT_SIZE = 5;

	//글 목록(리스트)
	@RequestMapping(value="/recipeList.app")
	public ModelAndView recipeList(@RequestParam(defaultValue ="1") int pageNum,
									@RequestParam(defaultValue = "5") int pageSize,
									HttpSession session) {
		
		if(pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;
		
		// 끝페이지 계산하는 메서드.
		int endPageNum = recipeService.getEndPageNum(pageSize);
		
		if(pageNum <= 0 ) pageNum = 1; // 페이지번호가 0보다 작거나 같을 수 없으니까 1페이지로 셋팅.
		if(pageNum > endPageNum) pageNum = endPageNum; // 페이지번호가 끝페이지 보다 클 경우에는 끝페이지번호가 페이지번호.
		
		List<?> recipeList = recipeService.recipeBoardList(pageNum, pageSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("currentPageNum", pageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("recipeList", recipeList);
		mav.setViewName("board_recipe/recipeList");

		return mav;
	}

	//글 쓰기 폼
	@RequestMapping(value="/recipeWriteForm.app")
	public ModelAndView recipeWriteForm(@RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_recipe/recipeWriteForm");

		return mav;		
	}

	//글 쓰기
	@RequestMapping(value="/recipeWrite.app")
	public String recipeWrite(@ModelAttribute RecipeBoardVO recipeVO, HttpSession session) {

		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");		
		recipeVO.setId(sessionVO.getId());

		recipeService.write(recipeVO);		

		return "redirect:/recipeList.app?pageNum="+1;		
	}


	//글 읽기
	@RequestMapping(value="/recipeContent.app")
	public ModelAndView recipeContent(@RequestParam int recipe_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int recipeCommentCount=0 ;

		recipeUserVO=recipeService.content(recipe_num);
		recipeCommentCount=recipeService.getCommentCount(recipe_num);	//댓글 개수

		mav.addObject("recipeUserVO", recipeUserVO);
		mav.addObject("pageNum", pageNum);
		mav.addObject("recipeCommentCount",recipeCommentCount);	

		mav.setViewName("board_recipe/recipeContent");		

		return mav ;
	}

	//글 수정 폼
	@RequestMapping(value="/recipeUpdateForm.app")
	public ModelAndView recipeUpdateForm(@RequestParam int recipe_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		recipeUserVO=recipeService.getUpdateRecipe(recipe_num);

		mav.addObject("recipeUserVO", recipeUserVO);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("board_recipe/recipeUpdateForm");		

		return mav ;		
	}

	//글 수정
	@RequestMapping(value="/recipeUpdate.app")
	public String recipeUpdate(@ModelAttribute RecipeBoardVO recipeVO, @RequestParam String pageNum) {

		recipeService.update(recipeVO);

		return "redirect:/recipeContent.app?recipe_num="+recipeVO.getRecipe_num() +"&pageNum=" + pageNum ;	
	}


	//글 삭제
	@RequestMapping(value="/recipeDelete.app")
	public String recipeDelete(@RequestParam int recipe_num) {
		
		recipeService.delete(recipe_num);

		return "redirect:/recipeList.app?pageNum=" + 1 ;	
	}

	//좋아요
	@Transactional
	@RequestMapping(value="/recipeLike.app")
	public ModelAndView recipeLike(@RequestParam int recipe_num, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> hashMap = new HashMap<>();	

		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");

		hashMap.put("recipe_num", recipe_num);
		hashMap.put("id", sessionVO.getId());		

		recipeService.addLikePeople(hashMap);	//좋아요 사람추가		

		mav.addObject("recipe_like", recipeService.addLike(recipe_num));
		mav.setViewName("JSON");

		return mav ; 		
	}

	//좋아요 취소
	@RequestMapping(value="/recipeDislike.app")
	public ModelAndView recipeDislike(@RequestParam int recipe_num, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> hashMap = new HashMap<>();	

		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");

		hashMap.put("recipe_num", recipe_num);
		hashMap.put("id", sessionVO.getId());		

		recipeService.minusLikePeople(hashMap);		//좋아요 누른 사람 빼기		

		mav.addObject("recipe_like", recipeService.minusLike(recipe_num));
		mav.setViewName("JSON");

		return mav ; 		
	}

	//좋아요 수 가져오기
	@RequestMapping(value="/getRecipeLike.app")
	public ModelAndView getRecipeLike(int recipe_num) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe_like", recipeService.getRecipeLike(recipe_num));
		mav.setViewName("JSON");

		return mav ; 		
	}

	//좋아요 누른 사람 체크
	@RequestMapping(value="/checkLikePeople.app")
	public ModelAndView checkLikePeople(@RequestParam int recipe_num, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("loginUser")==null) {
			
			mav.addObject("checkLikePeople", 0);
			return mav ;
		}
	
		HashMap<String, Object> hashMap = new HashMap<>();
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");

		hashMap.put("recipe_num", recipe_num);
		hashMap.put("id", sessionVO.getId());		

		mav.addObject("checkLikePeople", recipeService.checkLikePeople(hashMap));	
		mav.setViewName("JSON");

		return mav ;
	}

	//조회수 추가
	@RequestMapping(value="/recipeHit.app")
	public ModelAndView recipeHit(int recipe_num) {
		ModelAndView mav = new ModelAndView();

		recipeService.recipeHit(recipe_num);
		mav.setViewName("JSON");

		return mav ;						
	}
}
