<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>

<script type="text/javascript">
function write1() {
	document.location.href="/multipart/write.multi";
}

function read() {
	document.location.href="/multipart/read.multi";
}

</script>

</head>
<body>

<form>
<!-- onclick="write()" 는 자바스크립트에 write() 라는 함수가 있기 때문에 사용 불가.-->
	<button type="button" onclick="write1()">글쓰기</button>
	<input type="button" onclick="read()" value="글읽기">
</form>

</body>
</html>