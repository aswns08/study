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
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="food/js/food_add.js"></script>
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
				<p>&nbsp&nbsp&nbsp 음식 등록하기</p>
			</h3>

			<br>

			<div class="well bs-component">

				<form class="form-horizontal" id="detailForm" name="detailForm" action="addFood.app" method="post" enctype="multipart/form-data">
				
				<input type="hidden" id="f_recipe" name="f_recipe" value="">
				<input type="hidden" id="f_ingredients" name="f_ingredients" value="">
				<input type="hidden" id="f_origin" name="f_origin" value="">
				<input type="hidden" id="r_num" name="r_num" value="${r_num}">

					<div class="form-group">
						<label for="foodName" class="col-sm-2 control-label">음식 이름</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="f_name" name="f_name">
						</div>
					</div>
					
					<div class="form-group">
						<label for="foodPic" class="col-sm-2 control-label">음식 대표사진</label>
						<div class="col-sm-4">
							<input type="file" id="food_mainFile" name="food_mainFile">
						</div>
					</div>

					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">가격</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="f_price" name="f_price">
						</div>
					</div>

					<div class="form-group">
						<label for="recipe" class="col-sm-2 control-label">레시피</label>
						<div class="col-sm-4" id="recipeClass">
							<textarea class="form-control" rows="2" id="1" placeholder="1단계 레시피를 입력하세요"></textarea>
						</div>
						
					</div>
					<label class="col-sm-2"></label>
					<button type="button" onclick="addRecipe()">레시피 단계 추가</button>

				<br>
				<br>


					<div class="form-group" id="addClass">
					
						<label for="ingredients1" class="col-sm-2 control-label"
							style="width: 180px">원재료명</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="ingredients1" placeholder="예)소고기">
						</div>
						<label for="origin1" class="col-sm-1 control-label">원산지</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="origin1" placeholder="예)국내산">
						</div>
					

					
				</div>
				<label class="col-sm-2"></label>
				<button type="button" onclick="addIngre()">원재료/원산지 추가</button><br><br>


				
					<div class="form-group">
						<label for="ex_date" class="col-sm-2 control-label" >유통기한</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="f_ex_date" name="f_ex_date" placeholder="예)제조일로부터 3일">
						</div>
					</div>

					<div class="form-group">
						<label for="foodPic" class="col-sm-2 control-label">음식사진</label>
						<div class="col-sm-4">
							<input type="file" id="food_files" name="food_files" multiple>
						</div>
					</div>

					<br>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" onclick="cancelAdd()" class="btn btn-default" value="취소하기">
							<input type="button" onclick="totalDetail()" class="btn btn-danger" value="메뉴 등록하기">
						</div>
					</div>
					
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
					<<p>Copyright &copy; | HomeCook | 홈에서쿡해요 | </p>
				</div>
			</div>
		</footer>
	</div>
	<!-- /.container -->

</body>

</html>
