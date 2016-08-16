<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>첨부화일 읽기</title>
</head>
<body>       
	<table border="1" width="500" align="center">	
	<c:forEach var="fileList" items="${allFileList}">	
	 <tr> 			 
		 <td>오리지날 이름</td>
		 <td><a href="/multipart/download.multi?saveFileName=${fileList.saveFileName}&originFileName=${fileList.originFileName}">${fileList.originFileName}</a></td>
		 <td>저장된 이름</td><td>${fileList.saveFileName}</td>
		 <td>화일 크기</td><td>${fileList.fileSize}</td>
		 <td>글 번호</td><td>${fileList.article_Num}</td>
	 </tr>	
	</c:forEach> 
	</table>
		 
</body>
</html>