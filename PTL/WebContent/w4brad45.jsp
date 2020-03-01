<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
	/>
<c:if test="${!empty param.delid }">
	<sql:update>
		DELETE FROM cust WHERE id = ?
		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>

<sql:query var="result">
	SELECT * from cust
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="w4brad46.jsp">Add New</a>	<%-- 一個新增的功能直接丟給46 --%>
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>Account</th>
		<th>Realname</th>
		<th>Del</th>
		<th>Edit</th>
	</tr>
	<c:forEach items="${result.rows }" var="row" >
		<tr>
			<td>${row.id }</td>
			<td>${row.account }</td>
			<td>${row.realname }</td>
			<script>
				function delConfirm(account){
					return confirm("DELETE " + account + "?");
				}
			</script>
			<td><a href='?delid=${row.id }' onclick="return delConfirm('${row.account}');">delete</a></td>
			<td><a href='w4brad47.jsp?editid=${row.id }'>Edit</a></td><%-- 修改的功能直接丟給47 --%>
		</tr>
	
	</c:forEach>

</table>
</body>
</html>