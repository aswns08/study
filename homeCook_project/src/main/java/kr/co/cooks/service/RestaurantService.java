package kr.co.cooks.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import kr.co.cooks.dao.RestaurantDao;
import kr.co.cooks.dao.ReviewDao;
import kr.co.cooks.dao.UserDao;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantFileVO;
import kr.co.cooks.vo.RestaurantVO;
import kr.co.cooks.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class RestaurantService {
	@Autowired RestaurantDao restaurantDao;
	@Autowired UserDao userDao;
	@Autowired ReviewDao ReviewDao;
	@Autowired ServletContext servletContext;
	
	
	public List<RestaurantFileListVO> restaurantList(){

		return restaurantDao.getRestaurant();

	}

	
	@Transactional()
	public void addRestaurant(RestaurantVO restaurantVO, MultipartHttpServletRequest multipartReq){
		
		userDao.setUserLevel(restaurantVO.getId());//식당주인 user_level을 1로 세팅
		restaurantDao.addRestaurant(restaurantVO);
		
		String fileUploadRealPath = servletContext.getRealPath("/fileUpload");
		
		File dir = new File(fileUploadRealPath);
		
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		
		if(multipartReq.getFile("restaurantFile").getOriginalFilename() != null) {
			
			List<MultipartFile> multiFile = multipartReq.getFiles("restaurantFile");
			Iterator<MultipartFile> iterator = multiFile.iterator();
			
			while(iterator.hasNext()) {
				MultipartFile uploadFile = iterator.next();
				String originFileName = uploadFile.getOriginalFilename();
				String saveFileName = originFileName;
				long fileSize = uploadFile.getSize();
				
				if(!originFileName.isEmpty()) {
					if(new File(fileUploadRealPath + "/" + originFileName).exists()) {

						StringTokenizer st = new StringTokenizer(originFileName, ".");
						ArrayList<String> ar = new ArrayList<String>();
						while(st.hasMoreTokens()){
							ar.add(st.nextToken());
						}
						saveFileName = ar.get(0);
						for(int i=0;i<ar.size();i++){
							if(i == ar.size()-1){
								saveFileName = saveFileName + "_" + System.currentTimeMillis() + "." + ar.get(i);
							}else{
								saveFileName = saveFileName + "." + ar.get(i);
							}
							
						}
						System.out.println(saveFileName);					
					}
					
					RestaurantFileVO restaurantFileVO = new RestaurantFileVO();
					restaurantFileVO.setOriginFileName(originFileName);
					restaurantFileVO.setSaveFileName(saveFileName);
					restaurantFileVO.setFileSize(fileSize);
					restaurantFileVO.setR_Num(restaurantVO.getR_Num());
					
					restaurantDao.addFileUpload(restaurantFileVO);
					
					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				} // if
				
			} // while
		} // if
	}
	
	public String rNumcheck(String r_Num){
		return restaurantDao.rNumcheck(r_Num);
	}
	
	public String rIdcheck(String id){
		return restaurantDao.rIdcheck(id);
	}
	
	//음식 유형별 식당 리스트 (메인에서 유형별로 음식 리스트 부를때)
	public List<RestaurantFileListVO> restaurantTypeList(String r_food_type){
		return restaurantDao.restaurantTypeList(r_food_type);
	}

	public void restaurantDelete(String r_Num){
		ReviewDao.deleteResReviewPhoto(r_Num);//식당삭제에서 리뷰삭제
		ReviewDao.deleteResReview(r_Num);//식당삭제에서 리뷰삭제
		System.out.println("삭제 : "+r_Num);
		restaurantDao.restaurantDelete(r_Num);
	}
	
	public String getResOwner(String r_num){
		return restaurantDao.getResOwner(r_num);
	}

	public String getResNum(String ownerID){
		return restaurantDao.getResNum(ownerID);
	}

}
