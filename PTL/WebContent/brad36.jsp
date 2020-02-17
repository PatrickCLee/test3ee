<%@page import="w2.tw.brad.beans.Member"%>
<%@page import="w3.tw.brad.myutils.BradAPI"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String[] var1 = {"value1","value2","value3","value4","value5"};
	pageContext.setAttribute("username", var1);
	
	String[] var2 = {"brad1","brad2","brad3","brad4","brad5",};
	request.setAttribute("username", var2);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("AAA");list.add("BBB");list.add("CCC");
	request.setAttribute("listdata", list);
	
	HashMap<String,String> map = new HashMap<>();
	map.put("k1","v1");map.put("k2","v2");map.put("k3","v3");
	request.setAttribute("map",map);
	
	Member member = new Member();
	member.setAccount("bbbb");
	member.setAge(19);
	member.setRealname("bbcc ddee");
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Username: ${username["0"] }<br>
<!-- 變數名稱相同情況下以pageContext優先 -->
Username2: ${requestScope.username[0] }<br> 
<!-- 在request的範圍下看username[0] -->
<%= var2[0] %>	<br>
List1: ${listdata["0"] } <br>
List2: ${listdata[1] } <br>
List3: ${listdata[param.i] } <br>
<!-- URI後方帶i參數 -->
Map1: ${map["k1"] }<br>
Map2: ${map.k2 }<br>
Map3: ${map[param.key] }<br>
<!-- URI後方帶參數 -->
Lottery1: <%= BradAPI.createLottery() %> <br>
Lottery2: ${BradAPI.createLottery() }<br>
random: ${Math.random() }<br>
Hello: ${BradAPI.sayHello(param.name) }<br>
<!-- URI後方帶參數 -->
${10 + 3 }<br>
${param.x } > ${param.y } => ${param.x > param.y }<br> <!-- 此處變成字串比較 -->
<!-- URI後方帶參數 -->
${(param.x == "10")?"YES":"NO"} <br>
${10 > 3 }	<br>
Account: ${member.account }<br> <!-- member.getAccount() -->
Age: ${member.age }<br>
Realname:${member.realname }<br>
</body>
</html>
<!-- 後端整理資料,前端呈現資料 -->