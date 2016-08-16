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
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="board_recipe/js/recipeContent.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

<style>
#inlineFooter, #recipe_like_form {
	display: inline-block;
}
</style>

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
						<li class="active"><a href="recipeList.app">나만 아는 레시피</a></li>
						<li><a href="reviewListView.app">음식후기</a></li>
					</ul>

				</div>
				
				<input type="hidden" id="pageNum " name="pageNum" value="${pageNum}">
				<input type="hidden" id="recipe_num" value="${recipeUserVO.recipe_num}">
				<input type="hidden" id="userId" value="${loginUser.id}">
				
				<div class="col-sm-9 col-md-10 main">
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">나만 아는 레시피</h2>

					<br>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>${recipeUserVO.recipe_title}</h4>
							<label for="id">글쓴이 : </label> ${recipeUserVO.name} <br>
						</div>
						<div class="panel-body">${recipeUserVO.recipe_content}</div>
						<div class="panel-footer">
							<div id="inlineFooter">
							<c:if test="${loginUser.id==null}">
								<a>좋아요</a> . 
								<a>댓글달기</a> . 							
							</c:if>
							
							<c:if test="${loginUser.id!=null}">
							
								<a onclick="clickLike()" id="like">좋아요</a>
								<a onclick="clickDislike()" id="dislike" hidden="hidden">좋아요 취소</a> . 
								<a onclick="getFocus()">댓글달기</a> .
							</c:if> 
								<a><span class="glyphicon glyphicon-thumbs-up"></span><div id="recipe_like_form"></div></a>

							</div>

							<!-- 게시글 수정/게시글 삭제 버튼을 좋아요/댓글달기 와 같은줄에 오게하기위해 id값 주고 style에서 inline-block 해줌 -->
							<div id="inlineFooter" style="float: right">
								<c:if test="${loginUser.id==recipeUserVO.id}">
								<a href="recipeUpdateForm.app?recipe_num=${recipeUserVO.recipe_num}&pageNum=${pageNum}">게시글 수정</a> .
								<a href="recipeDelete.app?recipe_num=${recipeUserVO.recipe_num}">게시글 삭제</a> .
								
								 
							</c:if>
							<a href="recipeList.app?pageNum=${pageNum}">목록으로</a>
							</div>
						</div>
					</div>
					
					
					<div class="well row" id="commentForm" style="margin-left: 0px; margin-right: 0px;">
							<input type="hidden" id="commentPageNum" value="1">
			

						<!-- 기존에 있는 코멘트 읽어오기 -->			
						 <div id="show_comment"></div>						
			

						<form class="form-horizontal" role="form">
							<div class="form-group" style="padding: 14px;">
						
							<textarea class="form-control" id="rcomment_content" name="rcomment_content" placeholder="댓글을 입력하세요!"></textarea>
							</div>
							<c:if test="${loginUser.id==null}">
								<button class="btn btn-primary pull-right" type="button" disabled="disabled">추가</button>
							</c:if>
							<c:if test="${loginUser.id!=null}">
								<button class="btn btn-primary pull-right" type="button" id="comment_write">추가</button>
							</c:if>
							
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
					<<p>Copyright &copy; | HomeCook | 홈에서쿡해요 | </p>
				</div>
			</div>
		</footer>
	</div>
	<!-- /.container -->

<jsp:include page="../common/sign_modal.jsp"/>

</body>

</html>
