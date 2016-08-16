<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>  
<head>
<title>자료형게시판</title>
</head>

<body>

<table width="700" >
  <tr>
    <td align="right" >
       <a href="/multipart/write.multi">글쓰기</a>
    </td>
  </tr>
</table>

<table border="1" width="700" cellpadding="2" cellspacing="2" align="center"> 
    <tr height="30" > 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >본문</td>       
      <td align="center"  width="150" >작성일</td>                
    </tr>

   <c:forEach var="article" items="${allList}">
   <tr height="30">
    <td align="center"  width="50" >
	  <c:out value="${article.article_Num}"/>	  
	</td>
    <td  width="250" >     
      <a href="/multipart/content.multi?article_Num=${article.article_Num}">
          ${article.content}</a>          
	</td>  
    <td align="center"  width="150">${article.write_date}</td>   
  </tr>
  </c:forEach> 
</table>
</center>
</body>
</html>