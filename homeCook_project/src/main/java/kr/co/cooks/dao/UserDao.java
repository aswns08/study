package kr.co.cooks.dao;

import java.util.List;
import java.util.Map;

import kr.co.cooks.vo.UserOrderVO;
import kr.co.cooks.vo.UserVO;

public interface UserDao {
	
	public String signUpEmailCheck(String signUp_email); 
	public UserVO existUser(Map<String, String> params);
	public void signUpUser(UserVO userVO);
	public void userUpdate(UserVO userVO);
	public void changePwd(Map<String, String> params);
	public List<UserOrderVO> orderList(String userId);
	public List<UserOrderVO> orderAllList();
	public void setUserLevel(String id);//식당주인 user_level을 1로 세팅
	
}
