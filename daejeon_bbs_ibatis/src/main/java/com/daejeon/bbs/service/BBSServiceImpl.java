package com.daejeon.bbs.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.daejeon.bbs.dao.BBSDaoService;
import com.daejeon.bbs.vo.BoardVO;

@Service
public class BBSServiceImpl implements BBSService{

	@Autowired BBSDaoService bbsDao;
	@Autowired Page page;

	@Override
	public int login(String id, String pwd) {

		String uid = "";

		int status = 0;
		uid = bbsDao.login_check(id);

		if(uid!="") {
			if(uid.equals(pwd)) {
				status = 1;
			} else {
				status = 2;
			}
		} else  {
			status = 3;
		}

		return status;

	}

	@Override
	public HashMap<String, Object> list(String pageNum) {

		List<BoardVO> articleList=null;
		HashMap<String, Object> hm = new HashMap<>();

		int count; // 총 글의 개수
		int pageSize=10; // 한페이지에 보여질 글의 갯수
		int pageBlock=10; // 한페이지에 보여질 링크 갯수

		// 페이지 번호는 request에서 받아오기 때문에 String으로 받았음.

		if(pageNum==null) {
			// list.daejeon 요청이 처음 들어오면 pageNum은 null이기 때문에 기본 1로 초기값 설정 => 1페이지를 보여줌. 
			pageNum="1";
		}

		count=bbsDao.getArticleCount();

		// 페이지 번호는 String이었으므로 정수로 형변환
		// 페이징 처리를 위해 현재 페이지번호, 총 글의 갯수, 디폴트 페이지사이즈(한 페이지에 보여질 글의 갯수), 디폴트 페이지블록 : 페이지가 몇 개씩 보이는 지 정하는 변수. 
		page.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);

		if (count > 0) {
			articleList = bbsDao.getArticles(page.getStartRow(), page.getEndRow());

		} else {
			articleList = null;
		}

		hm.put("count", count);
		hm.put("articleList", articleList);
		hm.put("pagecode", page.getSb().toString());

		return hm;

	}

	@Override
	public BoardVO getArticle(int article_Num) {

		return bbsDao.getArticle(article_Num);

	}

	@Override
	public void write(BoardVO article, MultipartFile springfname) {
		// 멀티파트 리졸버는 파일이 업로드되지 않을 경우 null 을 리턴하는 것이 아니라
		// ""을 리턴해줌. 그래서 파일업로드를 하지 않아도 널포인트 익셉션이 발생하지 않음
		// 일반적으로 생각하면 파일업로드를 하지 않으면
		// springfname.getOriginalFilename() != null
		// 에러남.. 파일을 업로드 하거나 안하거나 전부 null 은 아님
		// 따라서 파일 업로드를 하지 않으면 d:/upload/폴더를 만들려고 해서
		// 존재하는 디텍토리 이므로 에러가 남.
		article.setFname(springfname.getOriginalFilename());
		
		try{
			if(!springfname.getOriginalFilename().equals("")) {
				// isEmpty() 를 사용해도 됨.
				// !springfname.isEmpty() 
				String realFolder = "d:/upload/";
				springfname.transferTo(new File(realFolder+springfname.getOriginalFilename()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		bbsDao.insertArticle(article) ;
	}
/*
	@Override
	public void delete(int article_Num) {

		bbsDao.deleteArticle(article_Num);

	}

	@Override
	public BoardVO getUpdateForm(int article_Num) {

		return bbsDao.getUpdate(article_Num);
	}

	@Override
	public void update(BoardVO article, int article_Num) {

		bbsDao.updateArticle(article, article_Num);
	}

	@Override
	public void reply(BoardVO article) {

		bbsDao.replyArticle(article);

	}
	
	@Override
	public int getCommentCount(int article_Num) {
		
		return bbsDao.getCommentCount(article_Num); 
	}
	
	
*/
}
