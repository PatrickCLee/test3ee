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
<sql:query var="rs1"> <%--將query結果放到變數rs1中 --%>	
SELECT * FROM opendata
</sql:query>
<c:set var="rpp" value="8" />	<%--result per page --%>
<%
	Result result =  (Result)pageContext.getAttribute("rs1");
	int rowCount = result.getRowCount();
	int rpp = Integer.parseInt((String)pageContext.getAttribute("rpp"));
	int pages = rowCount % rpp == 0 ? rowCount / rpp : rowCount / rpp + 1;
	pageContext.setAttribute("pages", pages);
%>
<c:set var="page" value="${param.page==null ? 1 : param.page }" />
<c:set var="start" value="${(page - 1) * rpp }" />
<c:set var="prev" value="${page == 1 ? 1 : page - 1 }" />

<c:set var="next" value="${page == pages ? page : page + 1 }" />

<sql:query var="result">
SELECT * FROM opendata limit ${start }, ${rpp }
</sql:query>
<%-- query: 將查詢的結果放在變數中,此時result是物件(整個資料表的內容) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
總筆數: ${rs1.rowCount }<br>
<a href="?page=${prev }">Prev</a> | <a href="?page=${next }">Next</a>
<hr>
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Address</th>
		<th>Tel</th>
		<th>LatLng</th>
		<th>Picture</th>
	</tr>
	<c:forEach items="${result.rows }" var="row" ><%--巡訪result每筆資料(此處result是被limit顯示數的資料),視他為row;rows是map陣列(被forEach),因此每個row是map型態 --%>
		<tr>
			<td>${row.id }</td>
			<td>${row.cname }</td>
			<td>${row.address }</td>
			<td>${row.tel }</td>
			<td>${row.latlng }</td>
			<td><img src="${row.picurl }" width="128px" height="72px"/></td>
		</tr>
	
	</c:forEach>

</table>
${result.rows[0] }	<%--此行幫助看觀念 --%>
</body>
</html>