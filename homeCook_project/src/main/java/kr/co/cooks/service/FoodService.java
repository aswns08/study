package kr.co.cooks.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import kr.co.cooks.dao.FoodDao;
import kr.co.cooks.dao.ReviewDao;
import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodMainFileListVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.StorageMapVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FoodService {
	@Autowired FoodDao foodDao ;
	@Autowired ReviewDao ReviewDao;
	@Autowired ServletContext servletContext;

	List<FoodMainFileListMapVO> foodFileList;
	List<FoodFileListVO> foodFilesList;
	
	//한 레스토랑에있는 음식 수
	public int getFoodCount(String r_num){
		return foodDao.getFoodCount(r_num);
	}

	
	//한 레스토랑에 있는 총 음식 리스트
	public List<FoodMainFileListMapVO> list(String r_num) {		
		return foodDao.getArticles(r_num) ;		
	}

	//음식 상세정보 가져오기
	public FoodMainFileListMapVO getFoodDetail(int f_num) {
		return foodDao.getFoodDetail(f_num);
	}


	//추가 사진들 가져오기
	public HashMap<String, Object> getFoodFiles(int f_num){
		HashMap<String, Object> hashMap = new HashMap<>();

		foodFilesList = foodDao.getFoodFiles(f_num);

		hashMap.put("foodFilesList", foodFilesList);	//음식이 들어있는 list

		return hashMap;
	}
	
	//레스토랑 정보 가져오기
	public RestaurantFileListVO getResInfo(String r_num){
		return foodDao.getResInfo(r_num);
	}

	//음식 등록하기 
	@Transactional()
	public void addFood(FoodVO foodVO, MultipartHttpServletRequest multipartReq) {

		//음식 정보 등록
		foodDao.addFood(foodVO);

		String fileUploadRealPath = servletContext.getRealPath("/fileUpload");

		File dir = new File(fileUploadRealPath);

		if(!dir.isDirectory()){
			dir.mkdir();
		}

		//음식 메인사진 
		if(multipartReq.getFiles("food_mainFile")!=null) {

			List<MultipartFile> multiFile = multipartReq.getFiles("food_mainFile");
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

					FoodMainFileListVO foodMainFileVO = new FoodMainFileListVO();
					foodMainFileVO.setOriginFileName(originFileName);
					foodMainFileVO.setSaveFileName(saveFileName);
					foodMainFileVO.setFileSize(fileSize);

					//메인사진 등록
					foodDao.addFoodMainFile(foodMainFileVO);

					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				}
			}
		}

		//음식 추가사진들
		if(multipartReq.getFiles("food_files")!=null) {


			List<MultipartFile> multiFile = multipartReq.getFiles("food_files");
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

					FoodFileListVO foodFileVO = new FoodFileListVO();
					foodFileVO.setOriginFileName(originFileName);
					foodFileVO.setSaveFileName(saveFileName);
					foodFileVO.setFileSize(fileSize);

					//메뉴 사진들 등록
					foodDao.addFoodFile(foodFileVO);

					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				}
			}		
		}

	}

	//음식 삭제하기 
	@Transactional
	public void deleteFood(int f_num) {

		ReviewDao.deleteFoodReviewPhoto(f_num);//푸드삭제에서 리뷰삭제
		ReviewDao.deleteFoodReview(f_num);//푸드삭제에서 리뷰삭제
		foodDao.deleteFoodMainFile(f_num);	//메인 사진 삭제
		foodDao.deleteFoodFiles(f_num);		//추가 사진들 삭제		
		foodDao.deleteFood(f_num);			//음식 정보 삭제

	}
	
	//음식 주문하기
	@Transactional
	public void buyFood(String userId, int f_num, int count, int useMileage, int o_price) {
		HashMap<String, Object> hashMap = new HashMap<>();
		
		FoodMainFileListMapVO foodFileMapVO = getFoodDetail(f_num);	//음식 정보 가져오기
		
		hashMap.put("f_num", f_num);
		hashMap.put("r_num", foodFileMapVO.getR_num());
		hashMap.put("o_count", count);
		hashMap.put("o_price", o_price); 	//실제 결제한 금액 계산(음식 가격*수량-사용한 마일리지)
		
		foodDao.addOrderNum(userId);		//구매번호 테이블에 구매내역 추가
		foodDao.addOrders(hashMap);			//구매 테이블에 구매내역 추가
		
		HashMap<String, Object> mileageMap = new HashMap<>();		
		
		mileageMap.put("mileage", useMileage);
		mileageMap.put("resultPrice", o_price*0.05);
		mileageMap.put("userId", userId);		
		
		foodDao.minusMileage(mileageMap);		//마일리지 차감
		foodDao.addMileage(mileageMap);			//마일리지 적립
		foodDao.addFoodCount(f_num); 			//음식 매출량++
	}
	
	//최신메뉴 가져오기
	public List<FoodMainFileListMapVO> getRecentFood() {
		return foodDao.getRecentFood();		
	}
	
	//검색된 이름의 음식 갯수
	public int foodSearchCount(String f_name) {
		f_name = '%'+f_name+'%';
		return foodDao.foodSearchCount(f_name);		
	}	
	
	//음식 검색했을 때 리스트	
	public List<FoodMainFileListMapVO> foodSearch(String f_name) {
		f_name = '%'+f_name+'%';
		return foodDao.foodSearch(f_name);		
	}
	
	//장바구니에 추가
	public void addJang(String userId, int f_num, int f_price, int f_count) {
		HashMap<String, Object> hashMap = new HashMap<>();
		
		hashMap.put("userId", userId);
		hashMap.put("f_num", f_num);
		hashMap.put("f_price", f_price);
		hashMap.put("f_count", f_count);
		
		foodDao.addJang(hashMap) ;		
	}
	
	//장바구니 보여주기
	public List<StorageMapVO> showJang(String userId) {
		return foodDao.showJang(userId) ;
	}
	
	//장바구니 음식 삭제
	public void deleteJangFood(int s_num) {		
		foodDao.deleteJangFood(s_num) ;
	}
}
