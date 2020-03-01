<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="br" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br:sayHello user="braa" />	<%-- 1,結合%(jsp語法)和EL語法帶參數 --%>
<br:calc x="10" y="3">		<%-- 2,tag內用c,變數帶到此頁,body的寫法 --%>
10 + 3 = ${add }<br>
10 - 3 = ${sub }<br>
10 * 3 = ${multiply }<br>
10 / 3 = ${divide }<br>
</br:calc>
<br:dojsp />				<%-- 3,% jsp語法 --%>
<hr />
<table border="1" width="100%">
	<tr>
		<th>Product Name</th>
		<th>Price</th>
	</tr>
	<br:myjsp name="Camera" price ="1,000" />	<%-- 4, --%>
	<br:myjsp name="Mouse" price ="200" />
	<br:myjsp name="iPhone" price ="31,000" />
</table>
</body>
</html>
<%--深入玩法:結合forEach和資料庫 --%>