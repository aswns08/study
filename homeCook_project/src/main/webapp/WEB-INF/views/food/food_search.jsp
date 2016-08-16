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
 <link href="main/css/main.css" rel="stylesheet">
 <link href="main/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="main/js/food_search.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

</head>

<body>
	<jsp:include page="../common/navTop.jsp" />
	
	<br>
	
	<!-- 검색창 -->
	<div class="col-md-12">
      <div class="input-group custom-search-form">
         <input type="text" class="form-control-search" id="food_Search" placeholder="음식이름을 검색해주세요">
         <span class="input-group-btn">
            <button type="button" class="btn btn-default" onclick="foodSearch()">
               <i class="fa fa-search"></i>
            </button>
         </span>
      </div>
      <br>
   </div>
 


	<!-- Page Content -->
	<div class="container">
   
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">
					<small> <b>${f_name}</b> 로 검색한 결과 ${count}개의 상품이 입니다</small>
				</h2>
			</div>
		</div>
		
		<!-- 검색된 음식 수가 0일경우 -->
		<c:if test="${count==0}">
	   		<img class="img-responsive img-center" src="food/images/noFood.png" alt="" id="noFoodImg" style="height: 400px; width:100%;">
	   	</c:if>

		<div class="row">
		<br>		
		
			<!-- 음식 리스트 -->
			<div class="row">
				<c:forEach var="food" items="${foodListMapVO}">
					
					<div class="col-sm-6" align="center">
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">
								<img class="img-circle img-responsive img-center" src="fileUpload/${food.saveFileName}" alt="" style="height: 300px; width: 300px;">
							</a>
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">${food.f_name}</a>
							<br>
						<c:out value="${food.f_price}"></c:out>
					</div>
					
				</c:forEach>
				</div>
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
