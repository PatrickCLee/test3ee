<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="w2.tw.brad.beans.Member" />
<%-- 上行可取代 <%@ page %>的指令 --%>
<jsp:useBean id="member" class="w2.tw.brad.beans.Member">	</jsp:useBean>
<jsp:setProperty property="account" value="${param.account }" name="member"/>
<%-- 	${param.account } 意同 <%= request.getParameter("account") %>  
	但整行意同 member.setAccount()
--%>
<jsp:setProperty property="realname" value="${param.realname }" name="member"/>
<jsp:setProperty property="age" value="<%= Integer.parseInt(request.getParameter(\"age\")) %>" name="member"/>   
<!-- 上方四行抄自29,但參數由30提供,先創物件再assign從30抓來的參數-->

<!-- 宣告 -->
<jsp:declaration>
	int a;
	String b;
</jsp:declaration>
<!-- scriptlet意思為 script的容器 -->
<jsp:scriptlet>	
	a = 10;
	b = "Brad";
</jsp:scriptlet>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  意同 <%= member.getAccount() %>  --%>
Account = ${member.account }	<br>
Realname = ${member.realname } <br>
Age = ${member.age }	<br>
${member }	<%-- 同一般class, 用toString操作 --%>
<hr>
a = <jsp:expression>a</jsp:expression> <br>
b = <jsp:expression>b</jsp:expression>
<!-- 上方為表現, 標籤內直接夾變數 -->
<hr>
Member = <jsp:expression>member</jsp:expression> <br>
Member = <%= member %> <br>
Member = ${member }
<!-- 上方三行為語法比較 -->
</body>
</html>
<!-- 搭30和Member, 此示範JSP EL表示法 $號{ } ; 用javaBean寫法它會自動去找無傳參數建構式及getter和setter帶入(其中不一定要使用EL語法), 但method名稱需正確-->