package com.daejeon.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daejeon.comment.service.CommentService;
import com.daejeon.comment.vo.CommentVO;

@Controller
public class CommetController {

	@Autowired CommentService cs;

	@RequestMapping("commentWrite.comment")
	public void commentWrite(@ModelAttribute CommentVO comment, 
			HttpSession session, HttpServletResponse res) {

		res.setCharacterEncoding("utf-8");
		comment.setId((String)session.getAttribute("id"));

		JSONArray jsonArray = new JSONArray(cs.commentWrite(comment));

		try {

			PrintWriter pw = res.getWriter();
			pw.println(jsonArray);
			pw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping("commentRead.comment")
	public void commentRead(@RequestParam int article_Num, int endRow, HttpServletResponse res) {

		res.setCharacterEncoding("utf-8");

		JSONArray jsonArray = new JSONArray(cs.commentRead(article_Num, endRow));

		try {

			PrintWriter pw = res.getWriter();
			pw.println(jsonArray);
			pw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
