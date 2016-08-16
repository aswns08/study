package com.daejeon.multipart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.multipart.service.MultiFileUploadServiceImpl;

@Controller
public class MultiFileUploadController {
	@Autowired MultiFileUploadServiceImpl musi;
	
	ModelAndView mav;
	
	@RequestMapping(value="/main.multi")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="/write.multi", method=RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	@Transactional()
	@RequestMapping(value="/write.multi", method=RequestMethod.POST)
	public ModelAndView write(MultipartHttpServletRequest mRequest) {
		
		musi.write(mRequest);
		
		mav = new ModelAndView();
		mav.setViewName("redirect:/read.multi");
		return mav;
	}
	
	@RequestMapping(value="/read.multi")
	public ModelAndView read() {
		mav = new ModelAndView();
		
		mav.addObject("allList", musi.read());
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping(value="/content.multi")
	public ModelAndView content(@RequestParam int article_Num) {
		mav = new ModelAndView();
		
		mav.addObject("allFileList", musi.content(article_Num));
		System.out.println(musi.content(article_Num));
		
		
		mav.setViewName("content");
		return mav;
	}
	
	@RequestMapping(value="download.multi")
	public ModelAndView download(@RequestParam String saveFileName, String originFileName) {
		mav = new ModelAndView();
		
		mav.addObject("saveFileName", saveFileName);
		mav.addObject("originFileName", originFileName);
		mav.setViewName("download");
		
		return mav;
	}
}
