<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="brad18.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = 10, b = 0;
	out.println(a / b);
%>
</body>
</html>
<!-- run搭18,  示範errorPage, 若無導向errorPage而直接除以0會出現500頁面及部份原始碼-->