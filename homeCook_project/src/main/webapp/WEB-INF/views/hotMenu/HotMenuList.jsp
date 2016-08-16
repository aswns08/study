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
     
    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">
    <link href='common/css/modalStyle.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

    <!-- Custom Fonts -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="css/main.css" rel="stylesheet">
	<link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<!-- Custom JS -->
	<script src="common/js/common.js"></script>
	<script src="common/js/signUp.js"></script>
</head>

<body>
	<jsp:include page="../common/navTop.jsp"/>
	
    <!-- Page Content -->
    <div class="container" style="margin-top: 100px;">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">인기메뉴 <b>HOT5</b>
                    <small>홈쿡에서 가장 HOT한 메뉴들을 소개합니다.</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- 인기메뉴 리스트 -->
        <c:forEach var="hotmenu" items="${hotmenulist}">
        <div class="row">
            <div class="col-md-6">    
                <a href="getFoodDetail.app?r_num=${hotmenu.r_num}&f_num=${hotmenu.f_num}">
                    <img class="img-responsive" src="fileUpload/${hotmenu.saveFileName}" style="height:300px;width: 550px;">
                </a>
            </div>
            <div class="col-md-6">        	
                <h2><img src="main/images/hot.png" alt="" id="hot" style="height: 40px; width: 60px;">  ${hotmenu.f_name}</h2>
                <h4>[${hotmenu.r_Name}]</h4>
                <h5>가격 : ${hotmenu.f_price}원</h5>               
                <a class="btn btn-primary" href="getFoodDetail.app?r_num=${hotmenu.r_num}&f_num=${hotmenu.f_num}">상세정보 <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
        <!-- /.row -->

        <hr>
        </c:forEach>
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