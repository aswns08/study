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

    <title>My Page-UserInfo</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="community/css/shop-homepage.css" rel="stylesheet">
    <link href='common/css/modalStyle.css' rel='stylesheet'>
    
    <style>
    .form-control{
    width: 70%;
    }
    </style>
    
    <!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
    <script src="common/js/common.js"></script>
    <script src="user/user.js"></script>

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
						<li><a href="showJang.app">장바구니</a></li>
						<li><a href="MyQNAlist.app">나의 Q & A</a></li>
						<li class="active"><a href="userInfo.app">회원정보수정</a></li>
						<li><a href="#findPwd" data-toggle="modal">비밀번호변경</a></li>
					</ul>

				</div>
				<!--/span-->

				<div class="col-sm-9 col-md-10 main">

					<h2 class="sub-header">회원정보수정</h2>
					<div class="table-responsive">

						<div id="wrapForm" >
							<form role="form">
								<div class="form-group" >

									<label for="usr">아이디</label>
									<input type="text" class="form-control" placeholder="E-mail" id="userId" value="${loginUser.id }" disabled>
									<br>
									
									<label for="name">이름</label>
									<input type="text" class="form-control" placeholder="USER NAME" id="userName" value="${loginUser.name }">
									<br>
									
									<label for="address">주소</label>
									<input type="text" class="form-control" placeholder="ADDRESS" id="userAddress" value="${loginUser.address }">
									<br>
									
									<label for="phone">연락처</label>
									<input type="text" class="form-control" placeholder="010-0000-0000" id="userPhone" value="${loginUser.phone }">
									<br>
									
									<label for="phone">비밀번호 확인</label>
									<input type="password" class="form-control" placeholder="PASSWORD" id="userPwd">
									<br>
								</div>
								
							</form>
							
							<div>
								<button type="button" id="userUpdateBtn" class="btn btn-lg btn-block btn-success" style="width:70%;">수정하기</button>
							</div>
						</div>

						

					</div> <!-- /table-responsive -->

				</div>
				<!--/row-->
			</div>

		</div> <!-- row -->
	</div> <!-- /container -->


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