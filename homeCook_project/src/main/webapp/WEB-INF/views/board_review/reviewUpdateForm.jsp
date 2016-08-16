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
<script src="js/jquery.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="board_free/js/freeUpdateForm.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

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

					<h2 class="sub-header">Cook's Review</h2>

					<br>

					<div class="well bs-component">
						
						<form class="form-horizontal" action="updateReview.app" method="post" enctype="multipart/form-data">
							<div class="form-group">
							
							<c:if test="${pageNum != null }">
								<input type="hidden" name="pageNum" value="${pageNum }">
							</c:if>
							
							<c:if test="${f_num != null && r_num != null }">
								<input type="hidden" name="f_num" value="${f_num }">
								<input type="hidden" name="r_num" value="${r_num }">
							</c:if>
							
							<input type="hidden" name="re_Num" value="${review.re_Num }">
								<label for="id">글쓴이 : </label> ${review.id}
								<hr>								
							</div>

							<div class="form-group">
								<label for="free_content">내 용</label>
								<textarea name="re_Content" class="form-control" rows="10" cols="7">${review.re_Content}</textarea>
							</div>
							<br>

							<div class="form-group">
								<button type="button" class="btn btn-default col-sm-1" onclick="#">취소</button>
								<button type="submit" class="btn btn-primary col-sm-1">수정하기</button>
							</div>

						</form>
					</div>

				</div>
			</div>

		</div> <!--/row-->
	</div> <!--/.container-->
	

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

<jsp:include page="../common/sign_modal.jsp"/>
</body>

</html>
