<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>업로드된 파일정보</h3>
파일명 : ${filename}<br>

<form action="download" method="post">
<input type="hidden" name="filename" value="${filename}">
<input type="submit" value="download">
</form>
</body>
</html>