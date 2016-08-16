<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<li class="active"><a href="freeList.app">자유게시판</a></li>
						<li><a href="recipeList.app">나만 아는 레시피</a></li>
						<li><a href="reviewListView.app">음식후기</a></li>
					</ul>

				</div>

				<div class="col-sm-9 col-md-10 main">
					<!-- <p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p> -->

					<h2 class="sub-header">자유게시판</h2>

					<br>

					<div class="well bs-component">

						<form class="form-horizontal" action="freeUpdate.app" method="post">
						<input type="hidden" name="free_num" id="free_num" value="${freeUserVO.free_num}">
						<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">
							<div class="form-group">
								<label for="id">글쓴이 : </label> ${freeUserVO.name}
								<hr>								
							</div>

							<div class="form-group">
								<label for="free_title">제 목</label> 
								<input type="text" name="free_title" class="form-control" value="${freeUserVO.free_title}">
							</div>

							<div class="form-group">
								<label for="free_content">내 용</label>
								<textarea name="free_content" class="form-control" rows="10" cols="7">${freeUserVO.free_content}</textarea>
							</div>
							<br>

							<div class="form-group">
								<button type="button" class="btn btn-default col-sm-1" onclick="freeWriteUpdate()">취소</button>
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
