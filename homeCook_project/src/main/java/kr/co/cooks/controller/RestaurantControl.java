package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.RestaurantService;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantControl {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	@Autowired RestaurantService restaurantService;
	RestaurantVO restaurantVO;
	
	
	@RequestMapping(value="/RestaurantList.app")
	public ModelAndView RestaurantList(){
		ModelAndView mav = new ModelAndView();
		
		List<RestaurantFileListVO> restaurantlist = restaurantService.restaurantList();
		
		mav.addObject("restaurantlist", restaurantlist);
		mav.setViewName("restaurant/resList");
		return mav;
	}
	

	@RequestMapping(value="/AddRestaurantForm.app")
	public ModelAndView AddRestaurantForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("restaurant/addResForm");
		return mav;
	}
	
	@RequestMapping(value="/AddRestaurant.app", method=RequestMethod.POST)
	public ModelAndView AddRestaurant(@ModelAttribute RestaurantVO restaurantVO,
									 MultipartHttpServletRequest multipartReq){
		
		restaurantService.addRestaurant(restaurantVO, multipartReq);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/RestaurantList.app");
		
		return mav;
	}
	
	@RequestMapping(value="/RestaurantOverlapCheck.app")
	public ModelAndView RestaurantOverlapCheck(@RequestParam String r_Num){
		
		ModelAndView mav = new ModelAndView();
		
		String restaurantNum = restaurantService.rNumcheck(r_Num);
		
		if(restaurantNum == null){
			mav.addObject("status", "success");
			mav.setViewName("JSON");
		} else{
			mav.addObject("status", "fail");
			mav.setViewName("JSON");
		}
	
		return mav;
	}

	@RequestMapping(value="/ResIdOverlapCheck.app")
	public ModelAndView ResIdOverlapCheck(@RequestParam String id){
		
		ModelAndView mav = new ModelAndView();
		
		String userid = restaurantService.rIdcheck(id);
		
		if(userid != null){
			mav.addObject("status", "success");
			mav.setViewName("JSON");
		} else{
			mav.addObject("status", "fail");
			mav.setViewName("JSON");
		}
	
		return mav;
	}
	
	@RequestMapping(value="/RestaurantDelete.app")
	public ModelAndView RestaurantDelete(@RequestParam String r_num){
		ModelAndView mav = new ModelAndView();
		System.out.println("레스토랑 등록번호 : " + r_num);
		restaurantService.restaurantDelete(r_num);
		mav.setViewName("redirect:/RestaurantList.app");
		return mav;
	}
	
}
