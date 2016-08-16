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
<link href="food/css/business-frontpage.css" rel="stylesheet">
<link href='common/css/modalStyle.css' rel='stylesheet'>

<!-- jQuery -->
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

</head>

<body>
	<jsp:include page="../common/navTop.jsp" />


	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<br>
			
			<!-- 식당 정보  -->
			<div class="col-md-6 portfolio-item" align="center">				
				<img class="img-responsive" src="fileUpload/${restaurant.saveFileName}" style="height: 340px; width: 500px;">
			</div>

			<div class="col-sm-6">
				<h1><strong><font face="배달의민족 한나는 열한살">${restaurant.r_Name}</font></strong></h1>	
				<p>${restaurant.r_Info}</p>
			</div>


			<div class="col-sm-6">
				<h3>[Contact Us]</h3>
				<address>
					<strong> 주소 : </strong>${restaurant.r_Address}<br>
					<strong> P : </strong>${restaurant.r_Phone}<br>
				</address>
			</div>
			
			<c:if test="${loginUser.id==restaurant.id || loginUser.user_Level==2}"> 
				<a href="addFoodForm.app?r_num=${r_num}"><input type="image" src="food/images/foodAddBtn.png" width="130" height="50"></a>						
			</c:if>
			
			<c:if test="${loginUser.user_Level==2}"> 
				<a href="RestaurantDelete.app?r_num=${r_num}"><input type="image" src="food/images/resDelBtn.png" width="130" height="50"></a>						
			</c:if>	

			<br><br>									
		</div> <!-- /.row -->


		<hr>
		
			<!-- 음식 리스트 -->
			<div class="row">		
			
			<c:if test="${count==0}">
				<img class="img-responsive img-center" src="food/images/noFood.png" alt="" id="noFoodImg" style="height: 400px; width:100%;">
			</c:if>
			
			<c:if test="${count!=0}">
			
			
				<c:forEach var="food" items="${foodFileList}">
					<div class="col-sm-6" align="center">
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">
								<img class="img-circle img-responsive img-center" src="fileUpload/${food.saveFileName}" alt="" style="height: 300px; width: 300px;">
							</a>
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">${food.f_name}</a>
							<br>
						<c:out value="${food.f_price}"></c:out> <br><br>
					</div>
					
				</c:forEach>
				
			</c:if>
			</div> <!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; | HomeCook | 홈에서쿡해요 | </p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

<jsp:include page="../common/sign_modal.jsp"/>
</body>

</html>
