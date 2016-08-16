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
    
    <style>
	.foodTypeline{
		width: 100%;
		height: 50px;
		background: #000000;
	}
	</style>    

</head>

<body>
	<jsp:include page="../common/navTop.jsp"/>
	
    <!-- Page Content -->
    <div class="container" style="margin-top: 100px;">

        <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${r_food_type}
                    <small>홈쿡의 공정하고 엄격한 기준에 따라 선정된 맛 집! 이제 집에서 즐기세요.</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->
        
        <!-- 음식 타입 -->
		<div class="foodTypeline" align="center">
	        <div class="col-sm-1" align="center">
	        </div>
	        <div class="col-sm-2" align="center">
	       		<a href="RestaurantList.app">
	      		<img class="img-responsive img-center" src="main/images/foodNavi1.png" alt="" id="totalres" style="height: 50px; width: 100px;">
	      		</a>
	        </div>
	        <div class="col-sm-2" align="center">
	        	<a href="restaurantTypeList.app?r_food_type=한식">
	       	 	<img class="img-responsive img-center" src="main/images/foodNavi2.png" alt="" id="hansickImg2"  style="height: 50px; width: 100px;">
	       	 	</a>
	        </div>
	        <div class="col-sm-2" align="center">
	        	<a href="restaurantTypeList.app?r_food_type=분식">
	       		<img class="img-responsive img-center" src="main/images/foodNavi3.png" alt="" id="bunsickImg2" style="height: 50px; width: 100px;">
	       		</a>
	        </div>
	        <div class="col-sm-2" align="center">
	        	<a href="restaurantTypeList.app?r_food_type=양식">
	      	  	<img class="img-responsive img-center" src="main/images/foodNavi4.png" alt="" id="yangsickImg2" style="height: 50px; width: 100px;">
	      	  	</a>
	        </div>
	        <div class="col-sm-2" align="center">
	        	<a href="restaurantTypeList.app?r_food_type=기타">
	       	 	<img class="img-responsive img-center" src="main/images/foodNavi5.png" alt="" id="etcImg2" style="height: 50px; width: 100px;">
	       	 	</a>
	        </div>
        </div>
        <br>  

        <!-- Projects Row -->
        <div class="row">
        	<c:forEach var="restaurant" items="${restaurantList}">
	       		<div class="col-md-4 portfolio-item">
	                <a href="foodList.app?r_num=${restaurant.r_Num}">
	                    <img class="img-responsive" src="fileUpload/${restaurant.saveFileName}" style="height:240px;width: 360px;">
	                </a>
	                <h3>
	                    <a href="foodList.app?r_num=${restaurant.r_Num}">${restaurant.r_Name}</a>
	                </h3>
	                <p>${restaurant.r_Info}</p>
	            </div>
           </c:forEach>
        

        </div>
        <!-- /.row -->
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