package kr.co.cooks.controller;

import java.util.List;

import kr.co.cooks.service.HotMenuService;
import kr.co.cooks.vo.FoodMainFileListMapVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotMenuControl {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	@Autowired HotMenuService hotMenuService;
	
	@RequestMapping(value="/HotMenuList.app")
	public ModelAndView HotMenuList(){
		ModelAndView mav = new ModelAndView();
		
		List<FoodMainFileListMapVO> hotmenulist = hotMenuService.hotmenulist();
		mav.addObject("hotmenulist", hotmenulist);
		mav.setViewName("hotMenu/HotMenuList");
		return mav;
	}
}
