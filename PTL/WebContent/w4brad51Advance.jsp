<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="br" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
	/>
<sql:query var="result">
	SELECT cname, picurl FROM opendata
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
	<tr>
		<th>Name</th>
		<th>Picture</th>
	</tr>
	<c:forEach items="${result.rows }" var="row">
	<br:myjspAdvance name="${row.cname }" pic="${row.picurl }" />	
	</c:forEach>
</table>
</body>
</html>
<%--深入玩法:將4結合forEach和資料庫,值用el帶 --%>