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

<title>홈쿡 주문완료</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="community/css/shop-homepage.css" rel="stylesheet">
<link href='common/css/modalStyle.css' rel='stylesheet'>

<!-- jQuery -->
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>


<!-- Custom JS -->
<script src="food/js/food_buy.js"></script>
<script src="common/js/signUp.js"></script>

<style>
.#ex_date {
	display: inline-block;
}
</style>

</head>


<body>
	<jsp:include page="../common/navTop.jsp" />

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<h3>
				<p>&nbsp&nbsp&nbsp 주문완료</p>
			</h3>

			<br>

			<div class="well bs-component">

				<form class="form-horizontal" id="detailForm" name="detailForm" action="addFood.app" method="post" enctype="multipart/form-data">
				
				

				<h4>주문이 완료되었습니다</h4>
					<a class="btn btn-primary btn-md" href="cooksMain.app">메인화면으로 돌아가기</a>
				<hr>
				</form>
			</div>

		</div>
	</div>

	<!-- Footer -->
	<div class="container">
		<hr>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; | HomeCook | 홈에서쿡해요 | </p>
				</div>
			</div>
		</footer>
	</div>
	<!-- /.container -->

</body>

</html>
