<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Oops!<br>
<%
	out.println(exception);
%>
</body>
</html>
<!-- 搭17,本頁isErrorPage -->