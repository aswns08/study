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
    <link href="main/css/main.css" rel="stylesheet">
    <link href="main/css/sb-admin-2.css" rel="stylesheet">
    <link href="main/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='common/css/modalStyle.css' rel='stylesheet'>
    <link href="food/css/business-frontpage.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
	<!-- Custom JS -->
	<script src="main/js/main.js"></script>
	<script src="main/js/food_search.js"></script>
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    

</head>
<body>

<jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
	<div>
	
	<div class="col-sm-1"></div>
	<h1>		
    	<small><center>이제 집에서도 쉐프의 요리를  즐기세요! 모든 재료를 보내드립니다!</center></small>
	</h1>

		<!-- <div class="col-sm-3" align="center">
			<a href="restaurantTypeList.app?r_food_type=한식">
			<img class="img-circle img-responsive img-center" src="main/images/hansick.png" alt="" id="hansickImg" style="height: 300px; width: 300px;">
			<img class="img-circle img-responsive img-center" src="main/images/hansick2.png" alt="" id="hansickImg2" style="height: 300px; width: 300px;">
			</a> 
		</div>
		<div class="col-sm-3" align="center">
			<a href="restaurantTypeList.app?r_food_type=분식">
			<img class="img-circle img-responsive img-center" src="main/images/bunsick.png" alt="" id="bunsickImg" style="height: 300px; width: 300px;">
			<img class="img-circle img-responsive img-center" src="main/images/bunsick2.png" alt="" id="bunsickImg2" style="height: 300px; width: 300px;">
			</a> 
		</div>
		<div class="col-sm-3" align="center">
			<a href="restaurantTypeList.app?r_food_type=양식">
			<img class="img-circle img-responsive img-center" src="main/images/yangsick.png" alt="" id="yangsickImg" style="height: 300px; width: 300px;">
			<img class="img-circle img-responsive img-center" src="main/images/yangsick2.png" alt="" id="yangsickImg2" style="height: 300px; width: 300px;">
			</a> 
		</div>
		<div class="col-sm-3" align="center">
			<a href="restaurantTypeList.app?r_food_type=기타">
			<img class="img-circle img-responsive img-center" src="main/images/etc.png" alt="" id="etcImg" style="height: 300px; width: 300px;">
			<img class="img-circle img-responsive img-center" src="main/images/etc2.png" alt="" id="etcImg2" style="height: 300px; width: 300px;">
			</a> 
		</div> -->
		<div id="menuTypeHeader" align="center">
			<div class="col-sm-2"></div>
			<div class="col-sm-2" align="center">
				<a href="restaurantTypeList.app?r_food_type=한식">
				<img class="img-circle img-responsive img-center" src="main/images/hansick.png" alt="" id="hansickImg" style="height: 200px; width: 200px;">
				<img class="img-circle img-responsive img-center" src="main/images/hansick2.png" alt="" id="hansickImg2" style="height: 200px; width: 200px;">
				</a> 
			</div>
		
			<div class="col-sm-2" align="center">
				<a href="restaurantTypeList.app?r_food_type=분식">
				<img class="img-circle img-responsive img-center" src="main/images/bunsick.png" alt="" id="bunsickImg" style="height: 200px; width: 200px;">
				<img class="img-circle img-responsive img-center" src="main/images/bunsick2.png" alt="" id="bunsickImg2" style="height: 200px; width: 200px;">
				</a> 
			</div>
			<div class="col-sm-2" align="center">
				<a href="restaurantTypeList.app?r_food_type=양식">
				<img class="img-circle img-responsive img-center" src="main/images/yangsick.png" alt="" id="yangsickImg" style="height: 200px; width: 200px;">
				<img class="img-circle img-responsive img-center" src="main/images/yangsick2.png" alt="" id="yangsickImg2" style="height: 200px; width: 200px;">
				</a> 
			</div>
			<div class="col-sm-2" align="center">
				<a href="restaurantTypeList.app?r_food_type=기타">
				<img class="img-circle img-responsive img-center" src="main/images/etc.png" alt="" id="etcImg" style="height: 200px; width: 200px;">
				<img class="img-circle img-responsive img-center" src="main/images/etc2.png" alt="" id="etcImg2" style="height: 200px; width: 200px;">
				</a> 
			</div>
		</div>
		<br>
	</div>

	<br><br><br>
	
	<!-- 검색창 -->
	<div class="col-md-14">
      <div class="input-group custom-search-form">
         <input type="text" class="form-control-search" id="food_Search" placeholder="음식이름을 검색해주세요">
         <span class="input-group-btn">
            <button type="button" class="btn btn-default" onclick="foodSearch()">
               <i class="fa fa-search"></i>
            </button>
         </span>
      </div>
    
       <div style="text-align:center"><h1><b>Let's Get Hyped For HomeCook!</b></h1></div><br>
   </div>
   
  

	<div class="container">
		<div class="row">
		
		<c:forEach var="food" items="${foodListMapVO}">
					
			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">
					<img src="fileUpload/${food.saveFileName}" alt="" style="height: 300px; width: 400px;"></a>
					<div class="caption">
						<h4 class="pull-right"><strong>${food.f_price}</strong></h4>
						<h4>
							<img src="main/images/new.png" alt="" id="new" style="height: 30px; width: 50px;">&nbsp
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">${food.f_name}</a>
						</h4>
					</div>
				</div>
			</div>
					
		</c:forEach>
		
		
		</div>
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