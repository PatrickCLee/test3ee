<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// taglib (標籤庫), JSTL
	// tomcat taglib download
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="member1" class="w2.tw.brad.beans.Member"></jsp:useBean>
<!-- 產生物件實體名為member1 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 	pageContext.setAttribute("x", "123");	同18行	
%>
<c:set var="x" value="123" scope="page" />
x = ${x }<br>
<%
// 	request.setAttribute("x", "123");	同23行	
%>
<c:set var="x" value="090" scope="request" />
x = ${requestScope.x }<br>

<c:out value="Hello, World" /><br>
<c:out value="${'Hello, World' }" /><br>
<c:out value="${y }" default="no y" /><br>
${y != null? y : "no value" }<br>

<c:set var="var1">9567</c:set>	<%-- value也可寫在標籤內 --%>
<c:out value="${var1 }" default="none" /><br>
<hr>
${member1 }<br>
<c:set target="${member1 }" property="account">Ben</c:set>
<c:set target="${member1 }" property="age">18</c:set>
<c:set target="${member1 }" property="realname" value="Brad Chao" />
<!-- target作用在哪個物件身上 -->
${member1.account }:${member1.realname }:${member1.age }<br>
${member1 }
<c:remove var="member1" />
${member1 }
</body>
</html>
<!-- 開始帶入tomcat taglib 做值的設定 -->