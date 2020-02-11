<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	if (name == null ) name = "OK";
	request.setAttribute("lottery", (int)(Math.random()*49+1)+"");//setAttribute的彈性 比用問號來帶 更大

	pageContext.setAttribute("key1", "value1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cool Story Bro</h1>
<hr>
<%@ include file="w2brad21.jsp" %>	<!-- 用include,21的頁面也可叫得到在此宣告的變數,在此視21為同一頁面,故request是同一個物件,又因同一頁故可使用pageContext的setAttribute -->
<hr>
<%= (String)(pageContext.getAttribute("key1")) %>
</body>
</html>
<!-- run搭21,示範setAttribute及指令@include -->