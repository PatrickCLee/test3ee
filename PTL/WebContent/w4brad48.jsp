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
<c:catch>
	<sql:transaction>
		<sql:update>
			INSERT INTO cust (account,realname) VALUES (?,?)
			<sql:param>Eri</sql:param>
			<sql:param>Eric Chan</sql:param>
		</sql:update>
		<sql:query var="lastid">
			SELECT last_insert_id() as newid
		</sql:query>
		<%-- 只要是select,結果都會是多筆資料,故下方要用rows[0] --%>
		<sql:update>
			UPDATE cust SET passwd= ? WHERE id = ?
			<sql:param>${lastid.rows[0].newid }</sql:param>
			<sql:param>2</sql:param>
		</sql:update>
		<%-- update若找不到條件不會失敗,只會回傳影響0列 --%>
	</sql:transaction>
	<%-- transaction交易機制,一項執行不成則全部都不會執行 --%>
</c:catch>
<%--每跑一次新增一筆Eric Chan,將最後一筆新增的id,更新在id為1的密碼欄位--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>