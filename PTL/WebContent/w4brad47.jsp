<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%--此頁負責修改 --%>

<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii?serverTimezone=Asia/Taipei"
	user="root"
	password="root"
	/>
<%-- 當user按下update後要進行的步驟 --%>
<c:if test="${!empty param.account }">
	<sql:update>
		UPDATE cust set account=?,passwd=?,realname=? WHERE id = ?
		<sql:param>${param.account }</sql:param>
		<sql:param>${param.passwd }</sql:param>
		<sql:param>${param.realname }</sql:param>
		<sql:param>${param.updateid }</sql:param>
	</sql:update>	
	<c:redirect url="w4brad45.jsp" />
</c:if>

<%--底下負責抓到要顯示在欄位中讓user修改的資料 --%>
<sql:query var="result">
	SELECT * FROM cust WHERE id = ?
	<sql:param>${param.editid }</sql:param>
</sql:query>
<%--用select得到的都會是多筆資料(即使出來結果只有一筆),觀念上仍為rows(map陣列),故下方要寫result.rows[0] --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="w4brad47.jsp">
	<input type="hidden" name="updateid" value="${param.editid }" />
	Account: <input name="account" value="${result.rows[0].account }" /><br>
	Password: <input type="password" name="passwd" value="${result.rows[0].passwd }" /><br>
	Realname: <input name="realname" value="${result.rows[0].realname }" /><br>
	<input type="submit" value="Update" /><br>
</form>

</body>
</html>