<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>글 읽기</title>

</head>
<body>

<form action="/BBSServlet/replyForm.daejeon" method="post">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="depth" value="${article.depth}">
	<input type="hidden" name="position" value="${article.position}">
	<input type="hidden" name="group_Id" value="${article.group_Id}">
	<table border="1" width="500" align="center">
		<tr>
			<td>글쓴이 : </td> <td>${article.id}</td>
			<td>조회수 : </td> <td>${article.hit}</td>
		</tr>
		<tr>
			<td>제목 : </td><td>${article.title}</td>
			<td>날짜 : </td><td>${article.write_Date}</td>
		</tr>
		<tr>
			<td colspan="2">다운로드 </td>
			<td colspan="2"><a href="/BBSServlet/download.daejeon?fname=${article.fname}">${article.fname}</a></td>
		</tr>
		<tr>
			<td colspan="4"><xmp>${article.content }</xmp></td>
		</tr>
		
		<tr>
	      <c:if test="${id !=null}">
	    	  <td colspan="4" align="right">	    	
	    	  <input type="submit" value="답글달기">
	    	  <c:if test="${id ==article.id}">
	    	  <input type="button" value="수정하기" onclick="document.location.href='/BBSServlet/updateForm.daejeon?article_Num=${article.article_Num}&pageNum=${pageNum}'">
	    	  <input type="button" value="삭제하기" onclick="document.location.href='/BBSServlet/delete.daejeon?article_Num=${article.article_Num}&pageNum=${pageNum}'">
	    	  </c:if>
	    	  <c:if test="${id !=article.id}">
	    	  <input type="button" value="수정하기" disabled="disabled">
	    	  <input type="button" value="삭제하기" disabled="disabled">
	    	  </c:if>
	    	  <input type="button" value="목록으로" onclick="document.location.href='/BBSServlet/list.daejeon?pageNum=${pageNum}'">
	    	  </td>
	      </c:if>
	      		    	
	      <c:if test="${id ==null}">
	    	  <td colspan="4" align="right">
	    	  <input type="submit" value="답글달기" disabled="disabled">
	    	  <input type="button" value="수정하기" disabled="disabled">
	    	  <input type="button" value="삭제하기" disabled="disabled">
	    	  <input type="button" value="목록으로" onclick="document.location.href='/BBSServlet/list.daejeon?pageNum=${pageNum}'">
	    	  </td>   
	      </c:if>      	 	      	 
	     </tr>	
	</table>
	
	<div id="show_comment" align="center"></div>
		
</form>


</body>
</html>


