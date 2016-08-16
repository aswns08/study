<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<link href="community/css/shop-homepage.css" rel="stylesheet">

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
	<script src="common/js/common.js"></script>
	<script src="common/js/signUp.js"></script>
	<script src="restaurant/addRes_writeForm.js"></script>
	<script src="restaurant/r_NumCheck.js"></script>
	<script src="restaurant/r_IdCheck.js"></script>
   
</head>


<body>

	<jsp:include page="../common/navTop.jsp"/>

	<!-- Page Content -->
	<div class="container">
	<div class="row">

		<h3>맛집 등록하기</h3>

		<br>
		
		<div class="well bs-component">

				<form class="form-horizontal" name="AddRestaurant" id="AddRestaurant" action="AddRestaurant.app" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="resName" class="col-sm-2 control-label">상호명</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="r_Name" name="r_Name">
						</div>
					</div>
					
					<div class="form-group">
						<label for="resName" class="col-sm-2 control-label">식당주인 아이디</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id">
						</div>
						<button type="button" id="r_IdCheckBnt" class="btn btn-default">등록가능여부</button>
					</div>

					<div class="form-group">
						<label for="resNumber" class="col-sm-2 control-label">사업자등록번호</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="r_Num" name="r_Num">
						</div>
						<button type="button" id="r_NumCheckBnt" class="btn btn-default">사업자등록번호 중복확인</button>

					</div>

					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="r_Address" name="r_Address">
						</div>
					</div>

					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="r_Phone" name="r_Phone" placeholder="예)02-123-4567">
						</div>
					</div>

					<div class="form-group">
						<label for="r_Foodtype" class="col-sm-2 control-label">음식유형</label>
						<div class="col-sm-4">							
							<input type="radio" name="r_Foodtype" value="한식"> 한식 &nbsp
  							<input type="radio" name="r_Foodtype" value="분식"> 분식 &nbsp
  							<input type="radio" name="r_Foodtype" value="양식"> 양식 &nbsp
  							<input type="radio" name="r_Foodtype" value="기타" checked>기타<br>							
						</div>
					</div>

					<div class="form-group">
						<label for="info" class="col-sm-2 control-label">식당정보</label>
						<div class="col-sm-4">
							<textarea class="form-control" id="r_Info" name="r_Info" maxlength="100" placeholder="식당에 대한 간단한 소개를 100자 내외로 적어주세요!"></textarea>
						</div>
					</div>


					<div class="form-group">
						<label for="foodPic" class="col-sm-2 control-label">맛집사진</label>
						<div class="col-sm-4">
							<input type="file" name="restaurantFile">		
						</div>
					</div>

					<br>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" id="addRescancel" class="btn btn-default" value="취소하기">
							<input type="button" id="addResBtn" class="btn btn-danger" value="맛집 등록하기">							
						</div>
					</div>
				</form>
				
			</div>

		</div>
	</div>

<!-- ................ Footer container ............ -->
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