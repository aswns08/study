package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.QNAVO;

public interface QNADao {
	public int getQnACount(int f_num);
	public List<QNAVO> getQnAList(int f_num);
	public int getMyQNACount(String id);
	public List<QNAVO> getMyQNA(String id);
	public int getMyAllQNACount();
	public List<QNAVO> getMyAllQNA();
	public int getMyOwnerQNACount();
	public List<QNAVO> getMyOwnerQNA(String resNum);
	public void qnaWrite(QNAVO qnaVO);
	public QNAVO qnaContent(int q_Num);
	public QNAVO getQNAUpdate(int q_Num);
	public void qnaUpdate(QNAVO qnaVO);
	public void qnaDelete(int q_Num);
	public void qnaDelete1(int q_Num);
	public void qnaGroupIdDownSet(int q_Num);//Q&A리플라이글만 삭제시 GroupId다시 0으로 세팅(댓글달기 버튼 추가하기 위해서)
	public void qnaReply(QNAVO qnaVO);
	public void qnaSetG_id(int qNum);//Q&A리플라이글 작성하면 GroupId다시 1로 세팅(댓글달기 버튼 제거하기 위해서)
}



