package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FoodService;
import kr.co.cooks.service.RestaurantService;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.RestaurantFileListVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainControl {
	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	@Autowired FoodService foodService ;
	@Autowired RestaurantService restaurantService;
	
	List<RestaurantFileListVO> restaurantList ;
	List<FoodMainFileListMapVO> foodListMapVO ;
	
	//메인화면
	@RequestMapping(value = "/cooksMain.app")
	public ModelAndView mainForm() {

		ModelAndView mav = new ModelAndView();

		//최신메뉴 가져오기
		foodListMapVO = foodService.getRecentFood();

		mav.addObject("foodListMapVO", foodListMapVO);
		mav.setViewName("main/main");

		return mav;
	}
	
	//메인에서 유형별로 음식 리스트 부를때
	@RequestMapping(value="/restaurantTypeList.app")
	public ModelAndView restaurantTypeList(@RequestParam String r_food_type, HttpSession session) {	

		ModelAndView mav = new ModelAndView();		
		
		restaurantList = restaurantService.restaurantTypeList(r_food_type);
		
		mav.addObject("r_food_type", r_food_type);
		mav.addObject("restaurantList", restaurantList);
		mav.setViewName("restaurant/res_TypeList");

		return mav;
	}
	
	//음식 검색
	@RequestMapping(value="/foodSearch.app")
	public ModelAndView foodSearch(@RequestParam String f_name, HttpSession session) {	

		ModelAndView mav = new ModelAndView();		
		
		int count = foodService.foodSearchCount(f_name);	//검색된 이름의 음식 갯수
		foodListMapVO = foodService.foodSearch(f_name);		//검색된 이름의 음식 정보
		
		mav.addObject("f_name", f_name);
		mav.addObject("count", count);
		mav.addObject("foodListMapVO", foodListMapVO);
		
		mav.setViewName("food/food_search");

		return mav;
	}
}
