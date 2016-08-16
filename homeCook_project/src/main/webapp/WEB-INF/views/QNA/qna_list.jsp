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
    <script src="user/user.js"></script>
</head>

<body>
<jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
				<div class="col-sm-12 main">
					<h2 class="sub-header">Q&A</h2>
					<b>글목록(전체 글:${count})</b>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th style="width: 10%;">번호</th>
									<th>제 목</th>
									<th style="width: 15%;">작성자</th>
									<th style="width: 15%;">날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="qnaVO" items="${qnaList}">
									<tr>
										<td><c:out value="${qnaVO.q_Num}"/></td>

										<td>
											<c:if test="${qnaVO.q_Dept == 1}">
												<img src="images/A.jpg" width="40" height="15">
											</c:if> 
											<c:if test="${qnaVO.q_Dept == 0}">
												<img src="images/Q.gif" width="15" height="15">
											</c:if> 
											
												<a href="QNAContent.app?q_Num=${qnaVO.q_Num}&pageNum=${pageNum}">${qnaVO.q_Title}</a>
										</td>
										<td>${qnaVO.id}</td>
										<td>${qnaVO.q_Date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:if test="${loginUser.id != null}">
 							<a href="QNAWriteForm.app?pageNum=${pageNum }">글쓰기</a>
						</c:if>
					</div>
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

    </div>
    <!-- /.container -->
    
<jsp:include page="../common/sign_modal.jsp"/>
    
</body>
</html>
