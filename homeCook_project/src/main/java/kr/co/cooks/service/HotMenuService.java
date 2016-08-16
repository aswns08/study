package kr.co.cooks.service;

import java.util.List;

import kr.co.cooks.dao.HotMenuDao;
import kr.co.cooks.vo.FoodMainFileListMapVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotMenuService {
	@Autowired HotMenuDao hotMenuDao;
	
	public List<FoodMainFileListMapVO> hotmenulist(){
		return hotMenuDao.getHotMenu();
	}

}
