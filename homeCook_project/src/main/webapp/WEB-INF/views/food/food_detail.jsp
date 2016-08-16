<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

 <title>홈쿡</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href='common/css/modalStyle.css' rel='stylesheet'>
<link href="food/css/food.css" rel="stylesheet">

<style>

#slogan {
   top: 50%;
   left: 50%;
   width: 600px;
   height: 400px;
   margin-left: 22%;
}

#foodFiles {
	margin-left: 18%;
}

#reContentWrap {
	height: 30px;
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

#reContentWrap.fullSize {
	height: 80px;
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

textarea {
	height: 100%;
	resize: none;
}

.star_rating {
	font-size: 0;
	letter-spacing: -4px;
}

.star_rating a {
	font-size: 22px;
	letter-spacing: 0;
	display: inline-block;
	margin-left: 5px;
	color: #ccc;
	text-decoration: none;
}

.star_rating a:first-child {
	margin-left: 0;
}

.star_rating a.on {
	color: #FFF522;
}
</style>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href='common/css/modalStyle.css' rel='stylesheet'>
<link href="food/css/food.css" rel="stylesheet">

<link href="community/css/shop-homepage.css" rel="stylesheet">
<link href='common/css/modalStyle.css' rel='stylesheet'>

<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="food/js/food_detail.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>
<script src="user/user.js"></script>
<script src="community/js/community.js"></script>

<script>var currentPageNum = 1;</script>

</head>

<body>
	<jsp:include page="../common/navTop.jsp" />
	<input type="hidden" id="f_num" value="${foodFileMapVO.f_num}">
	<input type="hidden" id="f_price" value="${foodFileMapVO.f_price}">
	<input type="hidden" id="userId" value="${loginUser.id}">
	<input type="hidden" id="f_recipe" value="${foodFileMapVO.f_recipe}">
	<input type="hidden" id="f_origin" value="${foodFileMapVO.f_origin}">
	<input type="hidden" id="f_ingredients" value="${foodFileMapVO.f_ingredients}">
	<input type="hidden" id="r_num" value="${foodFileMapVO.r_num}">

	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img class="img-responsive" id="mainFile" src="fileUpload/${foodFileMapVO.saveFileName}" alt="" style="height: 350px; width: 600px;">
			</div>
	
			<div class="menu-info">
				<h1><strong>${foodFileMapVO.f_name}</strong></h1>
				
				<table class="menuinfo-text">
					<tr>
						<td><font size="3">가격</font></td>
						<td><font size="3">${foodFileMapVO.f_price}원</font></td>
					</tr>
					<tr>
						<td><font size="3">마일리지</font></td>
						<td><font size="3"><c:out value="${foodFileMapVO.f_mileage}"></c:out>원(5%)</font></td>

					</tr>
					<tr>
						<td><font size="3">구매수량</font></td>
						<td><select class="form-control qty-select-form" id="foodCount" name="foodCount">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
						</select></td>
					</tr>
				</table>
		
				<c:if test="${loginUser.id==null}">						 
					<a onclick="alert('로그인을 하셔야 구매하실 수 있습니다')">			
						<input type="image" src="food/images/buyBtn.png" width="130" height="50">
					</a>							
					<a onclick="alert('로그인을 하셔야 장바구니에 보관하실 수 있습니다')">
						<input type="image" src="food/images/JangBtn.png" width="130" height="50">
					</a>					
				</c:if> 
				<c:if test="${loginUser.id!=null}"> 	
					<input type="image" src="food/images/buyBtn.png" onclick="beforBuy()" width="130" height="50">
					<input type="image" src="food/images/JangBtn.png" onclick="jangbaguni()" width="130" height="50">												
				</c:if>
				
				<c:if test="${loginUser.id==resUser || loginUser.user_Level==2}">					
					<a href="deleteFood.app?r_num=${foodFileMapVO.r_num}&f_num=${foodFileMapVO.f_num}"><input type="image" src="food/images/foodDelBtn.png" width="130" height="50"></a>						
				</c:if> 	
					
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="themline">
					<p style="font-size: 20px; color: #d85c9a; text-align:center;">Menu</p>
				</div>
				<br>

				<!-- 사진부분 -->				
				<img src="food/images/slogan1.png" alt="slogan" id="slogan"><br><br>
				
				<c:forEach var="files" items="${foodFilesList}">
					<img src="fileUpload/${files.saveFileName}" id="foodFiles" alt="" align="middle" style="height: 400px; width: 700px;">
					<br><br><br>
				</c:forEach>
				
						
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; text-align:center;">Recipe</p>
					</div>
					
					<div class="recipe">
						<br>
						<h3 id="howToCook"><b> < ${foodFileMapVO.f_name} > 만드는 법!</b></h3><br>

						<div class="form-group">
							<label for="foodName" class="col-sm-1 control-label"><font size="4">주재료</font></label>
							<div id="show_ingre"></div>
						</div>
						<hr>
						
						<div class="form-group">
							<!-- <label for="foodName" class="col-sm-1 control-label">1</label>
							<p></p> -->
							<div id="show_recipe"></div>	
						</div>						
						<br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; text-align:center;">Detail</p>
					</div>					
					<div class="product-list-text">
						<p style="font-size: 20px;">유통기간</p>
						<p>${foodFileMapVO.f_ex_date} </p>
					</div>
					
				</div>
				
				<div class="col-md-12">
					<div class="origin-text">
						<p style="font-size: 20px;">원산지 안내</p>		
							<div id="show_origin"></div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; text-align:center;">Review</p>
					</div>
					
					<div class="table-responsive">
						<table class="table table-striped" id='reviewListTable'>
							<thead>
								<tr>
									<th style="width: 6%;">#</th>
									<th style="width: 12%; text-align: center;">이미지</th>
									<th>제 목</th>
									<th style="width: 12%; text-align: center;">작성자</th>
									<th style="width: 9%; text-align: center;">날짜</th>
									<th style="width: 10%; text-align: center;">평점</th>
								</tr>
							</thead>
							<tbody id='reviewListTbody' style="font-size: 14px;">
								<!-- review.js 에서 반복문으로 <tr>, <td>를 append 함. -->
							</tbody>
						</table>
						<c:if test="${loginUser != null }">			
							<div id="tweetFromDiv">			
								<form id="tweetFrom" name="tweetFrom" action="writeReview.app" method="post" enctype="multipart/form-data">
									<div class="form-group">
									
										<div id="reContentWrap" style="cursor: text">
											<textarea id="re_Content" name="re_Content" cols="161%" placeholder="음식의 맛은 어땠나요?"></textarea>
											<div id="addBtn" class="col-sm-10" style="padding-left: 0px; width:100%">
											
												별점 : <p id="star_rating" class="star_rating" style="display: inline-block; width: 15%;"> 
												    <a href="#" class="on" id=reviewStar1>★</a>
												    <a href="#" class="on" id=reviewStar2>★</a>
												    <a href="#" class="on" id=reviewStar3>★</a>
												    <a href="#" id=reviewStar4>★</a>
												    <a href="#" id=reviewStar5>★</a>
												</p>
												
												<input type="file" value="사진추가" id="re_Fname" multiple name="re_Fname" style="display: inline-block; width: 52%;">                                    
                                    			<img src="images/writeBtn.png"  id="writeReviewBtn" width="90" height="40" align="right" style="display: inline-block;">
												<input type="hidden" value="3" id="re_Grade" name="re_Grade">
												<input type="hidden" value="${foodFileMapVO.f_num}" name="f_num">
												<input type="hidden" value="${foodFileMapVO.r_num}" name="r_num">
												<br>
											</div>
											<br>
										</div>
									</div>
										
								</form>
							</div>
						</c:if>
					</div>
						
					
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; text-align:center;">QnA</p>
					</div>
					
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th style="width: 10%;">번호</th>
									<th>제 목</th>
									<th style="width: 15%;">작성자</th>
									<th style="width: 15%;">날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="qnaVO" items="${qnaList}">
									<tr>
										<td><c:out value="${qnaVO.q_Num}"/></td>

										<td>
											<c:if test="${qnaVO.q_Dept == 1}">
												<!-- <img src="food/images/arrowMark.png" width="35" height="25">
												<img src="food/images/answerIcon.png" width="35" height="35"> -->												
												<img src="food/images/QNA_A.png" width="20" height="20">
											</c:if> 
											<c:if test="${qnaVO.q_Dept == 0}">
												<!-- <img src="food/images/questionIcon.png" width="35" height="35"> -->
												<img src="food/images/QNA_Q.png" width="20" height="20">												
											</c:if> 
											
												<a href="QNAContent.app?q_Num=${qnaVO.q_Num}&r_num=${foodFileMapVO.r_num}&f_num=${foodFileMapVO.f_num}">${qnaVO.q_Title}</a>
										</td>
										<td>${qnaVO.name}</td>
										<td>${qnaVO.q_Date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:if test="${loginUser.id != null}">
						
 							<a href="QNAWriteForm.app?r_num=${foodFileMapVO.r_num}&f_num=${foodFileMapVO.f_num}">
 								<img src="images/writeBtn.png"  width="90" height="40" align="right" style="display: inline-block;">
 							</a>
						</c:if>
					</div>
					
					
					
					
					
				</div>
			</div>
		</div>
	</div>



	<!--     </div> -->
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; | HomeCook | 홈에서쿡해요 | </p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

<jsp:include page="../common/sign_modal.jsp"/>
</body>

</html>
