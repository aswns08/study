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
	<script src="community/js/community.js"></script>
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    <script src="qna/myQna_replywriteForm.js"></script>
    
    
</head>

<body>

 <jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
        
        <div class="row row-offcanvas row-offcanvas-left">

				<!--/span-->

				<div class="col-sm-12 main">

					<!--toggle sidebar button-->
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">Q&A</h2>
				
			<div>

						<form>
							<input type="hidden" name="f_num" id="f_num" value="${f_num}">
							<input type="hidden" id="q_Num" value="${q_Num}">
							<div class="form-group">
								<label for="id">글쓴이 : </label> ${loginUser.name}
								<hr>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">제 목</label> 
								<input type="text" class="form-control" id="q_Title" name="q_Title" placeholder="제목을 입력하세요.">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">내 용</label>
								<textarea class="form-control" rows="3" cols="7" id="q_Content" name="q_Content" placeholder="내용을 입력하세요."></textarea>
							</div>
							
							<a href="MyQNAContent.app?q_Num=${q_Num}&f_num=${f_num}">
								<input type="button" class="btn btn-default col-sm-1" value="취소">
							</a>
					
							<input type="button" class="btn btn-primary col-sm-1" id="qnaReplyWriteBtn" value="글쓰기">
							
						</form>

					</div>	
						
					</div>

				</div>
				<!--/row-->
			</div>

		</div> <!-- row -->

	
	<!-- /container -->


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
