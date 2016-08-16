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

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>
<script>var currentPageNum = ${pageNum};</script>
<script>var endPageNum = ${endPageNum};</script>

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
						<li class="active" id="active-sidebar"><a href="freeList.app">자유게시판</a></li>
						<li><a href="recipeList.app">나만 아는 레시피</a></li>
						<li><a href="reviewListView.app">음식후기</a></li>
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

					<h2 class="sub-header">자유게시판</h2>
<!-- 
					<c:if test="${count == 0 }">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<td>게시판에 저장된 글이 없습니다</td>
									</tr>
								</thead>
							</table>
						</div>
					</c:if>
 -->

					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>조회수</td>
								</tr>
							</thead>
							
							<tbody>
							
							<c:forEach var="free" items="${freeList}">
								<tr>
									<td>
										<c:out value="${free.free_num}"></c:out>
									</td>
									<td>
										<a href="freeContent.app?free_num=${free.free_num}&pageNum=${pageNum}">${free.free_title}</a>
									</td>
									<td>
										<c:out value="${free.name}"></c:out>
									</td>
									<td>
										<c:out value="${free.free_date}"></c:out>
									</td>
									<td>
										<c:out value="${free.free_hit}"></c:out>
									</td>									
								</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- 페이징처리 -->
						<c:forEach var="index" begin="1" end="${endPageNum}" step="1">
							<a href="freeList.app?pageNum=${index }">&nbsp;${index }&nbsp;</a>
						</c:forEach>
						
					 	<form action="freeWriteForm.app" method="post">
							<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">
							<input type="hidden" id="userId" value="${loginUser.id}">
							<c:if test="${loginUser.id!=null}">
								<input type="image" src="images/writeBtn.png" alt="Submit" width="90" height="40" align="right">								
							</c:if>
						</form>
					</div>

				</div> <!--/row-->
			</div>

		</div> <!-- row -->
	</div> <!-- /container -->


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

	</div> <!-- /.container -->
	
  <jsp:include page="../common/sign_modal.jsp"/>

</body>

</html>
