<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

     <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                	<a href="cooksMain.app"><img src="main/images/logo.png" id="logoImage" alt="" style="height: 60px; width: 150px;"></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
                 <ul class="nav navbar-nav navbar-right">
                   <c:if test="${loginUser == null}">
                      <li id="signUpBtn"><a href="#signUp" data-toggle="modal" class="glyphicon glyphicon-user" data-keyboard="true"> 회원가입</a></li>
                      <li id="loginBtn"><a href="#signIn" data-toggle="modal" class="glyphicon glyphicon-log-in" data-keyboard="true"> 로그인</a></li>
                      <li><a href="" class="glyphicon glyphicon-shopping-cart" onclick="alert('로그인을 먼저하세요');"> 장바구니</a></li>
                   </c:if>
                
                 <c:if test="${loginUser != null}">
                      	<li id="userPage"><a href="#" class="glyphicon glyphicon-user"> ${loginUser.name }</a></li>
                        <li id="logoutBtn"><a href="#" class="glyphicon glyphicon-log-out"> 로그아웃</a></li>
                        <li id="jangBtn"><a href="showJang.app" class="glyphicon glyphicon-shopping-cart"> 장바구니</a></li>
                   </c:if>                                                    
               </ul>
            
            </div> <!-- /.navbar-collapse -->
        </div> <!-- /.container -->

        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
                <ul class="nav navbar-nav">
                    <li><a href="HotMenuList.app">인기메뉴</a></li>
                    <li><a href="RestaurantList.app">맛집</a></li>
                    <li><a href="freeList.app">커뮤니티</a></li>
                    <li><a href="NoticeList.app">공지사항</a></li>
                    <li><a href="reviewListView.app">음식후기</a></li>
                    <c:if test="${loginUser != null}">
                    <li><a href="userOrderList.app">마이페이지</a></li>
                    </c:if>
					<c:if test="${loginUser.user_Level == 2}">
						<li><a href="AddRestaurantForm.app">맛집등록</a></li>
					</c:if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
<!--     </nav> -->
    </nav>
    
   
<script>

/* 로그아웃. */
$('#logoutBtn').click(function(event) {
	
	$.getJSON('logoutUser.app', function(data) {
		if(data.status == 'success') {
			location.href = 'cooksMain.app';
		} else {
			alert('로그아웃 되지 않았습니다.');
		}
	});
	
});

/* 회원정보 페이지 */
$('#userPage').click(function(event) {
	location.href = 'userOrderList.app';
});
</script>
