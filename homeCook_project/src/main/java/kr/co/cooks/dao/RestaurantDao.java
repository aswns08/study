package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantFileVO;
import kr.co.cooks.vo.RestaurantVO;

public interface RestaurantDao {
	public List<RestaurantFileListVO> getRestaurant();
	public void addRestaurant(RestaurantVO restaurantVO);
	public void addFileUpload(RestaurantFileVO restaurantFileVO);
	public String rNumcheck(String r_Num);
	public String rIdcheck(String id);
	public void restaurantDelete(String r_Num);
	public String getResOwner(String r_num);//주인 아이디 가져오기
	public String getResNum(String ownerID);//식당번호 가져오기
	
	//음식 유형별 식당 리스트
	public List<RestaurantFileListVO> restaurantTypeList(String r_food_type);

}
