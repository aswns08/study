<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" enctype="multipart/form-data">
<title>Insert title here</title>
</head>
<body>

<form action="/mybatis/write.daejeon" method="post" enctype="multipart/form-data">
	<table border="2" width="200">
		<tr>
			<td>글쓴이 :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea cols="50" rows="20" name="content">
			</textarea>
			</td>
		</tr>
		<tr>
			<td>첨부 : </td>
			<td><input type="file" name="springfname" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="글쓰기"></td>
			<td><input type="reset" value="글쓰기취소"></td>
		</tr>
	</table>

</form>

</body>
</html>