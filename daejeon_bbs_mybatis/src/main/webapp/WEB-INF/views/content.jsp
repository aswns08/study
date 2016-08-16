<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(document).ready(function() {
	$("#comment_write").click(function() {
		$.ajax({
			type: "POST",
			url: "/mybatis/commentWrite.comment",
			async: true,
			dataType: "json",
			data: {
				article_Num:$("#article_Num").val(),
				comment_Content:$("#comment_content").val(),
			},
			success : function(data) {
				//alert("성공");
				var html = '<table border="1">';
// 				@Responsebody 사용시
// 				$.each(data,function(entryIndex, entry) {
				$.each(data.comment,function(entryIndex, entry) {
// 					MappingJacksonJsonView 사용할 때
					var formatted_date = new Date(entry.comment_date);
					
					html += '<tr>';
					html += '<td>' + entry.comment_Num + '</td>';
					html += '<td>' + entry.id + '</td>';
					html += '<td>' + entry.comment_Content + '</td>';
// 					html += '<td>' + formatted_date + '</td>';
// 					html += '<td>' + formatted_date.toLocaleDateString() + '</td>';
// 					html += '<td>' + formatted_date.toLocaleTimeString() + '</td>';
					html += '<td>' + formatted_date.toLocaleString() + '</td>';
					html += '<td>' + entry.article_Num + '</td>';
					html += '</tr>';
				});
				html += '</table>';
				$("#show_comment").html(html);
		
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}
		});
		
		// alert($("#comment_content").val());
		// alert($("textarea").val());
		// alert($("textarea[name=comment_content]").val());
		
	});
});

function getComment(commPageNum, event) {
	event.preventDefault();
	if(commPageNum==1) {
		$("#commPageNum").val(1);
	}
	
	commPageNum = parseInt(commPageNum);
	$.ajax({
		type : "POST",
		url : "/mybatis/commentRead.comment",
		async : true,
		dataType : "json",
		data : {
			article_Num : $("#article_Num").val(),
			endRow : commPageNum * 20
		},
		success : function(data) {
			if ('${commentCount}' > 20 && '${commentCount}' > commPageNum*20) {
				currentPageNum=$("#commPageNum").val();
				currentPageNum=parseInt(currentPageNum)+1;
				$("#commPageNum").val(currentPageNum);
				
				var html = '<input type="button" onclick="getComment(currentPageNum, event)" value="다음댓글보기">';

			} else {
				var html = "";
			}
			html += '<table border="1">';

			$.each(data.comment, function(entryIndex, entry) {
				var formatted_date = new Date(entry.comment_date);
				html += '<tr>';
				html += '<td>' + entry.comment_Num + '</td>';
				html += '<td>' + entry.id + '</td>';
				html += '<td>' + entry.comment_Content + '</td>';
				//html += '<td>' + formatted_date + '</td>';
				//html += '<td>' + formatted_date.toLocaleDateString() + '</td>';
				//html += '<td>' + formatted_date.toLocaleTimeString() + '</td>';
				html += '<td>' + formatted_date.toLocaleString() + '</td>';
				html += '<td>' + entry.article_Num + '</td>';
				html += '</tr>';
			});
			html += '</table>';
			$("#show_comment").html(html);
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
</script>
<title>글 읽기</title>

</head>
<body>

<form action="/mybatis/replyForm.daejeon" method="post">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="depth" value="${article.depth}">
	<input type="hidden" name="position" value="${article.position}">
	<input type="hidden" name="group_Id" value="${article.group_Id}">
	<input type="hidden" id="article_Num" value="${article.article_Num}">
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
			<td colspan="2"><a href="/mybatis/download.daejeon?fname=${article.fname}">${article.fname}</a></td>
		</tr>
		<tr>
			<td colspan="4"><xmp>${article.content }</xmp></td>
		</tr>
		
		<tr>
	      <c:if test="${id !=null}">
	    	  <td colspan="4" align="right">	    	
	    	  <input type="submit" value="답글달기">
	    	  <c:if test="${id ==article.id}">
	    	  <input type="button" value="수정하기" onclick="document.location.href='/mybatis/updateForm.daejeon?article_Num=${article.article_Num}&pageNum=${pageNum}'">
	    	  <input type="button" value="삭제하기" onclick="document.location.href='/mybatis/delete.daejeon?article_Num=${article.article_Num}&pageNum=${pageNum}'">
	    	  </c:if>
	    	  <c:if test="${id !=article.id}">
	    	  <input type="button" value="수정하기" disabled="disabled">
	    	  <input type="button" value="삭제하기" disabled="disabled">
	    	  </c:if>
	    	  <input type="button" value="목록으로" onclick="document.location.href='/mybatis/list.daejeon?pageNum=${pageNum}'">
	    	  </td>
	      </c:if>
	      		    	
	      <c:if test="${id ==null}">
	    	  <td colspan="4" align="right">
	    	  <input type="submit" value="답글달기" disabled="disabled">
	    	  <input type="button" value="수정하기" disabled="disabled">
	    	  <input type="button" value="삭제하기" disabled="disabled">
	    	  <input type="button" value="목록으로" onclick="document.location.href='/mybatis/list.daejeon?pageNum=${pageNum}'">
	    	  </td>   
	      </c:if>      	 	      	 
	     </tr>
	     <tr>
	     	<td colspan="3">
	     		<a href="#" onclick="getComment(1, event)">덧글(${commentCount})</a>
	     	</td>
	     </tr>
	     <tr>
	     	<td>
	     		<textarea name="comment_content" id="comment_content"></textarea>
	     		<c:if test="${id==null }">
	     			<input type="button" value="comment 쓰기" disabled="disabled">
	     		</c:if>
	     		<c:if test="${id !=null }">
	     			<input type="button" value="comment 쓰기" id="comment_write">
	     		</c:if>
	     	</td>
	     </tr>	
	</table>
</form>

<form action="commentForm">
	<input type="hidden" id="commPageNum" value="1">
	<div id="show_comment" align="center"></div>
</form>
		
</body>
</html>


