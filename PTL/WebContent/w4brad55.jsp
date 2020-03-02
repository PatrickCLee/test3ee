<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// cookie 在 client端
	// session 在 server端, session對server負擔重
	if (session.getAttribute("account") == null){
		response.sendRedirect("w4brad53.jsp");
		return;
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cool Story Bro</h1>
Welcome, ${account }	<%-- account這個attribute,若page找不到則找request,不行再往session --%>
<hr>
<a href="w4logout.jsp">Logout</a>
</body>
</html>
