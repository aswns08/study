package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.QNADao;
import kr.co.cooks.vo.NoticeVO;
import kr.co.cooks.vo.QNAVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
public class QNAService {
	@Autowired QNADao qnaDao;
	@Autowired RestaurantService restaurantService;
	QNAVO qnaVO;
	List<QNAVO> qnaList;

	public int getQnACount(int f_num) {

		return qnaDao.getQnACount(f_num);
	}

	public List<QNAVO> qnalist(int f_num) {

		return qnaDao.getQnAList(f_num);
	}

	public List<QNAVO> myqnalist(String id) {

		return qnaDao.getMyQNA(id);
	}

	public int getMyQNACount(String id) {

		return qnaDao.getMyQNACount(id);
	}

	public List<QNAVO> myqnaAllList() {
		HashMap<String,Object> hm = new HashMap<>();
		int count=0;

		count=qnaDao.getMyAllQNACount();		

		hm.put("count", count);
		hm.put("qnaList", qnaList);

		return qnaDao.getMyAllQNA();
	}
	
	public List<QNAVO> myqnaOwnerlist(String ownerID){

		String resNum = restaurantService.getResNum(ownerID);
		
		if(resNum != null){
			qnaList = qnaDao.getMyOwnerQNA(resNum);
		} else {
			qnaList = qnaDao.getMyQNA(ownerID);
		}
		
		return qnaList;
	}

	public void qnaWrite(QNAVO qnaVO){

		qnaDao.qnaWrite(qnaVO);
	}

	public QNAVO qnaContent(int q_Num){
		return qnaDao.qnaContent(q_Num);
	}


	public QNAVO getQNAUpdate(int q_Num){
		return qnaDao.getQNAUpdate(q_Num);
	}

	public void qnaUpdate(QNAVO qnaVO){
		qnaDao.qnaUpdate(qnaVO);
	}

	@Transactional
	public void qnaDelete(int q_Num){
		qnaDao.qnaGroupIdDownSet(q_Num);//Q&A리플라이글만 삭제시 GroupId다시 0으로 세팅(댓글달기 버튼 추가하기 위해서)
		qnaDao.qnaDelete1(q_Num);	//Q&A글 삭제하기전에 리플라이글 삭제
		qnaDao.qnaDelete(q_Num);	//Q&A글 & 리플라이 글 삭제
	}

	public void qnaReply(QNAVO qnaVO){
		qnaDao.qnaSetG_id(qnaVO.getQ_Num());//Q&A리플라이글 작성하면 GroupId다시 1로 세팅(댓글달기 버튼 제거하기 위해서)
		qnaDao.qnaReply(qnaVO);
	}


}
