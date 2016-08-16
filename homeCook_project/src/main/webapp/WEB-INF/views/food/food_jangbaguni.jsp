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
<link href="community/css/shop-homepage.css" rel="stylesheet">
<link href='common/css/modalStyle.css' rel='stylesheet'>

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="common/js/food_jangbaguni"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

</head>


<body>
<jsp:include page="../common/navTop.jsp"/>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="row row-offcanvas row-offcanvas-left">

				<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">

					<ul class="nav nav-sidebar" style="margin-top: 15px;">
						<li><a href="userOrderList.app">구매내역</a></li>
						<li  class="active"><a href="showJang.app">장바구니</a></li>
						<li><a href="MyQNAlist.app">나의 Q & A</a></li>
						<li><a href="userInfo.app">회원정보수정</a></li>
						<li><a href="#findPwd" data-toggle="modal">비밀번호변경</a></li>
					</ul>

				</div>
				<!--/span-->

				<div class="col-sm-9 col-md-10 main">

					<!--toggle sidebar button-->
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h3>
						<p>&nbsp&nbsp&nbsp 장바구니</p>
					</h3>
					<br>
					
					<div class="table-responsive">
						<table class="table table-striped" id='jangListTable'>
							<thead>
								<tr>									
									<th style="width: 12%; text-align: center;">이미지</th>
									<th>음식이름</th>
									<th style="width: 12%; text-align: center;">적립금</th>
									<th style="width: 12%; text-align: center;">판매가</th>
									<th style="width: 10%; text-align: center;">수량</th>
									<th style="width: 10%; text-align: center;">합계</th>
									<th style="width: 10%; text-align: center;">구매/삭제</th>
									
								</tr>
								
								<c:forEach var="storage" items="${storage}">					
								<tr>									
									<td style="width: 12%; text-align: center;">
										<a href="getFoodDetail.app?r_num=${storage.r_num}&f_num=${storage.f_num}">
										<img class="img-responsive" id="mainFile" src="fileUpload/${storage.saveFileName}" alt="" style="height: 5em; width: 95%;">
										</a>
									</td>
									<td><a href="getFoodDetail.app?r_num=${storage.r_num}&f_num=${storage.f_num}"><b>${storage.f_name}</b></a></td>
									<td style="width: 12%; text-align: center;">${storage.s_mileage}원</td>
									<td style="width: 12%; text-align: center;">${storage.s_price}원</td>
									<td style="width: 10%; text-align: center;">${storage.s_count}</td>						
									<td style="width: 10%; text-align: center;">${storage.s_price*storage.s_count}원</td>
									<td style="width: 10%; text-align: center;">
										<a href="buyFoodForm.app?f_num=${storage.f_num}&count=${storage.s_count}&s_num=${storage.s_num}"><input type="image" src="food/images/jangBuyBtn.png" width="95%" height="30"></a>
										<a href="deleteJangFood.app?s_num=${storage.s_num}"><input type="image" src="food/images/jangFoodDelBtn.png" width="95%" height="30"></a>
									</td>
								</tr>
								</c:forEach>								
							</thead>							
						</table>
						<a href="RestaurantList.app"><input type="image" src="food/images/shoppingBtn.png" onclick="" width="150" height="40"></a>
						
						</div>
							


					
				</div> <!--/row-->
			</div>

		</div> <!-- row -->
	</div> <!-- /container -->


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

	</div> <!-- /.container -->
	
  <jsp:include page="../common/sign_modal.jsp"/>

</body>

</html>
