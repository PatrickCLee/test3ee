<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%--此頁負責新增帳號 --%>

<c:if test="${!empty param.account }">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii?serverTimezone=Asia/Taipei"
		user="root"
		password="root"
		/>
	<sql:update var="count">
		INSERT INTO cust (account,passwd,realname) values (?,?,?)
		<sql:param>${param.account }</sql:param>
		<sql:param>${param.passwd }</sql:param>
		<sql:param>${param.realname }</sql:param>
	</sql:update>
	<%-- 當變更資料庫時會回傳變更幾筆資料,存到變數count中 --%>
	<c:redirect url="w4brad45.jsp" />
	<%-- 新增成功後轉回45,顯示全部帳號的頁面 --%>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="w4brad46.jsp"> <!-- 若是呼叫自己也可不寫action屬性 -->
	Account: <input name="account" /><br>
	Password: <input type="password" name="passwd" /><br>
	Realname: <input name="realname" /><br>
	<input type="submit" value="Add" /><br>
</form>

</body>
</html>