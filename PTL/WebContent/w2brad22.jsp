<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= (String)(pageContext.getAttribute("key")) %>
</body>
</html>
<!-- 獨立的一個jsp, 因此叫不到 -->