<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int lottery1 = (int)(Math.random()*49+1);
	int lottery2 = (int)(Math.random()*49+1);
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

<!-- 之前用下指令的方式"@"去include, 現在用標籤的方式 -->
<!-- 在此可設定 request parameter,且將它帶出去給別人 -->
<jsp:include page="w2brad24.jsp"> 
	<jsp:param name="key1" value="<%= lottery1 %>" />
	<jsp:param name="key2" value="<%= lottery2 %>" />
</jsp:include> 
<hr>

</body>
</html>
<!-- run搭24,示範不用%的方式來include -->