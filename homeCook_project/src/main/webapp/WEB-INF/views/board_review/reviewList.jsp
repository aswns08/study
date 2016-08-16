<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link href="community/css/shop-homepage.css" rel="stylesheet">
    <link href='common/css/modalStyle.css' rel='stylesheet'>

	<style>
#reContentWrap {
	height: 30px;
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

#reContentWrap.fullSize {
	height: 80px;
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

textarea {
	height: 100%;
	resize: none;
}

.star_rating {
	font-size: 0;
	letter-spacing: -4px;
}

.star_rating a {
	font-size: 22px;
	letter-spacing: 0;
	display: inline-block;
	margin-left: 5px;
	color: #ccc;
	text-decoration: none;
}

.star_rating a:first-child {
	margin-left: 0;
}

.star_rating a.on {
	color: #FFF522;
}


</style>
	
	<!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    <script src="user/user.js"></script>
    <script src="board_review/js/reviewList.js"></script>
	<script>var currentPageNum = ${pageNum};</script>
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
						<li><a href="NoticeList.app">공지사항</a></li>
						<li><a href="freeList.app">자유게시판</a></li>
						<li><a href="recipeList.app">나만 아는 레시피</a></li>
						<li class="active"><a href="reviewListView.app">음식후기</a></li>
					</ul>
			</div>
			
			
				<div class="col-sm-9 col-md-10 main">

					<h2 class="sub-header">홈쿡</h2>
		
		<c:if test="${loginUser != null }">			
		<div id="tweetFromDiv">			
			<form id="tweetFrom" name="tweetFrom" action="writeReview.app" method="post" enctype="multipart/form-data">
				<div class="form-group">
				
					<div id="reContentWrap" style="cursor: text">
						<textarea id="re_Content" name="re_Content" cols="133%" placeholder="음식의 맛은 어땠나요?"></textarea>
						<div id="addBtn" class="col-sm-10" style="padding-left: 0px; width:100%">
						
							별점 : <p id="star_rating" class="star_rating" style="display: inline-block; width: 15%;"> 
							    <a href="#" class="on" id=reviewStar1>★</a>
							    <a href="#" class="on" id=reviewStar2>★</a>
							    <a href="#" class="on" id=reviewStar3>★</a>
							    <a href="#" id=reviewStar4>★</a>
							    <a href="#" id=reviewStar5>★</a>
							</p>
							
							<input type="file" value="사진추가" id="re_Fname" multiple name="re_Fname" style="display: inline-block; width: 52%;">
							<img src="images/writeBtn.png"  id="writeReviewBtn" width="90" height="40" align="right" style="display: inline-block;">							
							<input type="hidden" value="3" id="re_Grade" name="re_Grade">
							<br>
						</div>
						<br>
					</div>
				</div>
					
			</form>
		</div>
		</c:if>
		
					<div class="table-responsive">
						<table class="table table-striped" id='reviewListTable'>
							<thead>
								<tr>
									<th style="width: 6%;">#</th>
									<th style="width: 12%; text-align: center;">이미지</th>
									<th>제 목</th>
									<th style="width: 12%; text-align: center;">작성자</th>
									<th style="width: 10%; text-align: center;">날짜</th>
									<th style="width: 10%; text-align: center;">평점</th>
								</tr>
							</thead>
							<tbody id='reviewListTbody' style="font-size: 14px;">
								<!-- review.js 에서 반복문으로 <tr>, <td>를 append 함. -->
							</tbody>
						</table>
						</div>
						
						<div id='pagingBar'></div>
						<!-- 
						<div id='pagingBar'>
						  <% for(int index=1; index <= 5; index++) { %>
						  <a href="#" onClick="loadReviewList(<%= index %>)"><%= index %></a>
						  <% } %>
						</div>
						 -->

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
