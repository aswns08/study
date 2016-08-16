package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.FoodMainFileListMapVO;

public interface HotMenuDao {
	
	public List<FoodMainFileListMapVO> getHotMenu();

}
