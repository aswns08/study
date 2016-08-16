<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

<form action="/multipart/write.multi" method="post" enctype="multipart/form-data">
	<table border="2" width="200">
		<tr>
			<td colspan="2">
			<textarea cols="50" rows="20" name="content">
			</textarea>
			</td>
		</tr>
		<tr>
			<td>첨부 : </td>
			<td><input type="file" multiple name="fname" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="글쓰기"></td>
			<td><input type="reset" value="글쓰기취소"></td>
		</tr>
	</table>

</form>

</body>
</html>