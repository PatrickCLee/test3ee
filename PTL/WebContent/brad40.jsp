<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="w3.tw.brad.myutils.BradAPI" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cool Story Bro</h1>
<hr>
<c:if test='${param.n == "100" }' var="result">
Hello, World<br>
</c:if>
${result }
<hr>
<c:set var="score">${BradAPI.randomScore() }</c:set>
Score: ${score }
<c:choose>
	<c:when test="${score >= 90 }">A</c:when>
	<c:when test="${score >= 80 }">B</c:when>
	<c:when test="${score >= 70 }">C</c:when>
	<c:when test="${score >= 60 }">D</c:when>
	<c:otherwise>E</c:otherwise>
</c:choose>
</body>
</html>
<!-- 用標籤語法寫邏輯 -->