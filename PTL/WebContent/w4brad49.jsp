<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--將撈到的資料(網頁)存在變數中 --%>
<c:import var="data" url="https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx"></c:import>
<%
	String strData = (String)pageContext.getAttribute("data");	//外面的變數沒寫scope都是page的,用get回傳的是物件型態
	LinkedList<HashMap<String,String>> data = new LinkedList<>();
	
	JSONArray root = new JSONArray(strData);
	for (int i=0; i<root.length(); i++){
		JSONObject row = root.getJSONObject(i);
		HashMap<String,String> map = new HashMap<>();
		map.put("name", row.getString("Name"));	//前面key名稱自訂,後方value的getString參數按照網頁上的名稱
		map.put("tel", row.getString("Tel"));
		data.add(map);
	}
	pageContext.setAttribute("pdata", data);
%>

<table border="1" width="100%">
	<c:forEach items="${pdata }" var="row"><%--巡訪上方的LL資料,名稱被設為pdata,每筆名為row,意同for(HashMap row : pdata) --%>
		<tr>
			<td>${row.name }</td>
			<td>${row.tel }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>