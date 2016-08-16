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

    <title>My Page-OrderList</title>

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
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    <script src="user/userOrderList.js"></script>

</head>
<body>

<jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
        
        <div class="row row-offcanvas row-offcanvas-left">

				<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
					role="navigation">

					<ul class="nav nav-sidebar" style="margin-top: 15px;">
						<li class="active"><a href="userOrderList.app">구매내역</a></li>
						<li><a href="showJang.app">장바구니</a></li>
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

					<h2 class="sub-header">주문내역/취소</h2>
					<div class="table-responsive">
						<br />
						
						<c:if test="${loginUser.user_Level==1 || loginUser.user_Level==0}">
							<h4>${loginUser.name } 님의 마일리지는 ${loginUser.mileage }점 입니다.</h4>
						</c:if>
						
						<c:if test="${loginUser.user_Level==2}">
							<h4>모든 주문내역</h4>
						</c:if>
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width: 12%; text-align: center;">구매날짜</th>
										<th style="width: 5%; text-align: center;">구매번호</th>
										<c:if test="${loginUser.user_Level==2 || loginUser.user_Level==1}">
											<th style="width: 8%; text-align: center;">구매자</th>
										</c:if>
										<th style="width: 15%; text-align: center;">상품명</th>
										<th style="width: 5%; text-align: center;">수량</th>
										<th style="width: 8%; text-align: center;">가격</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="orderList" items="${orderList}">
										<tr>
											<td style="text-align: center;">${orderList.o_Date }</td>
											<td style="text-align: center;">${orderList.o_Num }</td>
											<c:if test="${loginUser.user_Level==2 || loginUser.user_Level==1}">
												<td style="text-align: center;">${orderList.id }</td>
											</c:if>
											<td style="text-align: center;">${orderList.f_Name }</td>
											<td style="text-align: center;">${orderList.o_Count }</td>
											<td style="text-align: center;">${orderList.o_Price }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
					</div>

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