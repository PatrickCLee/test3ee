<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (!session.isNew()){
		if (session.getAttribute("account") != null){
			response.sendRedirect("w4brad55.jsp");			
		}else{
			response.sendRedirect("logout.jsp");
		}
	}
	//來到此頁應該是新的session,若已登入(session不是新的),回到已登入的畫面;不知怎麼弄把他session弄不見一律logout
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="w4brad54.jsp">
	Account:<input name="account" /><br>
	Password:<input type="password" name="passwd" /><br>
	<input type="submit" value="Login" />
</form>
</body>
</html>
<%--為何此處的網址不會帶參數? --%>
