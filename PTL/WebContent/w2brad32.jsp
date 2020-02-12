<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="w2brad32.jsp">
		<input type="number" name="x" value="${param.x }" />
		+
		<input type="number" name="y" value="${param.y }" />
		<input type="submit" value="=" />
		${param.x + param.y }	<%-- 無參數時不會出錯,此處會顯示0因為有經過數學+號運算 --%>
	</form>
</body>
</html>
<!-- EL表示法,可搭33或自己 -->