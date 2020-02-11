<%@page import="w2.tw.brad.javaee.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = (Member)application.getAttribute("member");
	member.addAge();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= member.getAccount() %><br>
<%= member.getRealname() %><br>
<%= member.getAge() %>
</body>
</html>
<!-- 後run搭25及javaee.Member類別 -->