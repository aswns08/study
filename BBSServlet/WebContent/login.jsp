<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 하세요 ~</title>
</head>
<body>

<form action="/BBSServlet/login.daejeon" method="post">
	<input type="hidden" value="${writeForm}">
	i   d : <input type="text" name="id"><br />
	p w d  : <input type="text" name="pwd"><br />
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
	<input type="button" value="회원가입">

</form>

</body>
</html>