package kr.co.cooks.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FoodService;
import kr.co.cooks.service.QNAService;
import kr.co.cooks.service.RestaurantService;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.QNAVO;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.StorageMapVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodControl {
	private static final Logger logger = LoggerFactory.getLogger(FoodControl.class);	
	@Autowired FoodService foodService ;
	@Autowired QNAService qnaService;
	@Autowired RestaurantService restaurantService;
	
	QNAVO qnaVO;
	FoodVO foodVO ;
	FoodMainFileListMapVO foodFileMapVO ;
	RestaurantFileListVO restaurantVO ;
	
	//한 레스토랑에 있는 총 음식 리스트
	@Transactional
	@RequestMapping(value="/foodList.app")
	public ModelAndView foodList(@RequestParam String r_num, HttpSession session) {	

		ModelAndView mav = new ModelAndView();
		List<FoodMainFileListMapVO> foodFileList=null ;
		
		restaurantVO = foodService.getResInfo(r_num) ;				//가게에 대한 정보
		int count = foodService.getFoodCount(r_num) ;				//한 레스토랑에있는 음식 수
		
		if(count!=0) {
			foodFileList = foodService.list(r_num);					//음식 리스트			
		}
		else if(count==0) {
			foodFileList = null ;
		}	
		
		mav.addObject("count", count);
		mav.addObject("r_num", r_num);
		mav.addObject("restaurant", restaurantVO);
		mav.addObject("foodFileList", foodFileList);
		mav.setViewName("food/food_list");

		return mav;
	}

	//음식 상세정보 가져오기
	@Transactional
	@RequestMapping(value="/getFoodDetail.app")
	public ModelAndView getFoodDetail(@RequestParam String r_num, int f_num, HttpSession session) {		
		ModelAndView mav = new ModelAndView();

		foodFileMapVO = foodService.getFoodDetail(f_num) ;					//음식 정보 가져오기
		HashMap<String, Object> hashMap=foodService.getFoodFiles(f_num);	//추가 사진들 가져오기						
		restaurantVO = foodService.getResInfo(r_num) ;						//가게에 대한 정보
		
		int totalQnA = qnaService.getQnACount(f_num);
		List<QNAVO> qnaList = qnaService.qnalist(f_num);					// 해당 음식의 QnA
		
		mav.addObject("qnaList", qnaList);
		mav.addObject("count", totalQnA);
		
		mav.addObject("foodFileMapVO", foodFileMapVO);
		mav.addObject("foodFilesList", hashMap.get("foodFilesList"));
		mav.addObject("resUser", restaurantVO.getId()); 					//레스토랑 주인 아이디 가져오기
		mav.setViewName("food/food_detail");

		return mav;
	}

	//음식 등록하기 폼
	@RequestMapping(value="/addFoodForm.app")
	public ModelAndView addFoodForm(@RequestParam String r_num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();

		mav.addObject("r_num", r_num);
		mav.setViewName("food/food_addForm");

		return mav;
	}

	//음식 등록하기 
	@RequestMapping(value="/addFood.app", method=RequestMethod.POST)
	public String addFood(@ModelAttribute FoodVO foodVO, HttpSession session, MultipartHttpServletRequest multipartReq) {	

		foodService.addFood(foodVO, multipartReq);

		return "redirect:/foodList.app?r_num=" + foodVO.getR_num() ;
	}

	//음식 삭제하기 
	@RequestMapping(value="/deleteFood.app")
	public String deleteFood(@RequestParam String r_num, int f_num, HttpSession session) {	

		foodService.deleteFood(f_num);

		return "redirect:/foodList.app?r_num=" + r_num ;
	}
	
	//음식 구매하기폼
	@RequestMapping(value="/buyFoodForm.app")
	public ModelAndView buyFoodForm(@RequestParam int f_num, int count, @RequestParam(defaultValue = "0") int s_num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		foodFileMapVO = foodService.getFoodDetail(f_num);		//음식 정보 가져오기

		mav.addObject("userVO", userVO);						//음식 구매하는 고객 정보
		mav.addObject("f_num", f_num);							//음식번호
		mav.addObject("f_name", foodFileMapVO.getF_name());		//음식이름
		mav.addObject("f_price", foodFileMapVO.getF_price());	//음식가격
		mav.addObject("count", count);							//수량
		mav.addObject("s_num", s_num);							//장바구니 번호		
	
		mav.setViewName("food/food_buyForm");

		return mav;
	}
	
	//음식 구매하기
	@Transactional
	@RequestMapping(value="/buyFood.app")
	public ModelAndView buyFood(@RequestParam int f_num, int count, int useMileage, int o_price, @RequestParam(defaultValue = "0") int s_num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		
		UserVO userVO = (UserVO)session.getAttribute("loginUser");	//구매자정보
		
		//장바구니에서 구매하기버튼 누른경우
		if(s_num!=0) {
			foodService.deleteJangFood(s_num);	
			System.out.println("장바구니에서 구매");			
		}		
		
		foodService.buyFood(userVO.getId(), f_num, count, useMileage, o_price);
		
		//마일리지 계산 (보유 마일리지 - 사용하고자하는 마일리지 + 최종결제금액*0.05)
		int resultMileage = userVO.getMileage() - useMileage + (int)(o_price*0.05) ;
		userVO.setMileage(resultMileage);
		
		session.setAttribute("loginUser", userVO);

		mav.setViewName("food/food_buyEnd");
		
		return mav;
	}
	
	//장바구니에 추가
	@RequestMapping(value="/addJang.app")
	public ModelAndView addJang(@RequestParam int f_num, int f_price, int f_count, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");	
		
		foodService.addJang(sessionVO.getId(), f_num, f_price, f_count);

		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;			
	}
	
	//장바구니 보여주기
	@RequestMapping(value="/showJang.app")
	public ModelAndView showJang(HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");
		
		List<StorageMapVO> storage = foodService.showJang(sessionVO.getId());
		
		mav.addObject("storage", storage);
		mav.setViewName("food/food_jangbaguni");
		
		return mav;			
	}
	//장바구니 음식 삭제
	@Transactional
	@RequestMapping(value="/deleteJangFood.app")
	public ModelAndView deleteJangFood(@RequestParam int s_num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");
		
		foodService.deleteJangFood(s_num);					//삭제
		List<StorageMapVO> storage = foodService.showJang(sessionVO.getId());	//목록 가져오기
		
		mav.addObject("storage", storage);
		
		mav.setViewName("food/food_jangbaguni");
			
		return mav;			
		}

}
