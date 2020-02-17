<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 隱含物件 request (不用new,已經存在)
	String method = request.getMethod();
	// 隱含物件 out 相當於 response.getWriter(),拿到PrintWriter
	out.println(method + "<br>");
	// 隱含物件 pageContext
// 	ServletRequest sr = pageContext.getRequest();
// 	out.println(sr == request);	//是同一個物件
	HttpServletRequest srr = 
			(HttpServletRequest)pageContext.getRequest();
	out.println((srr == request) + "<br>");
	
	String remoteIP = request.getRemoteAddr();	//遠端IP,亦即來訪者IP
	out.println(remoteIP + "<br>");
	
	String qs = request.getQueryString();	//拿到傳來的參數
	out.println(qs + "<br>");
	
	String[] likes = request.getParameterValues("like");
	for(String like : likes)out.println(like + "<br>");
	
	String country = 
			pageContext.getResponse().getLocale().getDisplayCountry();
	out.println(country);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
Method = ${pageContext.request.method }<br>
<!-- pageContext擁有request這個屬性,request如上也有method -->
Remote IP = ${pageContext.request.remoteAddr }<br>
Query String = ${pageContext.request.queryString}<br>
Account: ${param.account }<br>
Password: ${param.passwd }<br>
Like1: ${paramValues.like[0] }<br>
Like2: ${paramValues.like[1] }<br>
Like3: ${paramValues.like[2] }<br>
Country: ${pageContext.response.locale.displayCountry }<br>
</body>
</html>
<!-- 搭34 -->