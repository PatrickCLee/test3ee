<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] names = {"Abe","Byran","Casey","Danny","Emory"};
	pageContext.setAttribute("namesla", names);
	/*
	for (String name : names){
		
	}
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<table border="1" width="100%">
	<tr>
		<th>Index</th>
		<th>Names</th>
		<th>Count</th>
		<th>First</th>
		<th>Last</th>
	</tr>
	<c:forEach items="${namesla }" var="name" varStatus="status"> <%--這句話前面念做 for(String name : namesla) ; status為每個物件的狀態物件 --%>
		<tr bgcolor="
			<c:choose>
				<c:when test="${status.index % 2 == 0 }">yellow</c:when>
				<c:otherwise>pink</c:otherwise>
			</c:choose>
		" }">  <%--上方bgcolor內可以直接用EL寫 <tr bgcolor="${status.index % 2 ==0?"yellow":"pink" }"> --%>
			<td>${status.index }</td>
			<td>${name }</td>
			<td>${status.count }</td>
			<td>${status.first }</td>
			<td>${status.last }</td>
		</tr>
	</c:forEach>
</table>	
	
</body>
</html>