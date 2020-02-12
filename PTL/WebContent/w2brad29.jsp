<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="member" class="w2.tw.brad.beans.Member">	</jsp:useBean>
<!-- 上一行丟到後端以tw.brad.beans.Member這個類別創造物件實體,變數名稱(id)叫做member -->
<!-- 意同 Member member = new Member() -->
<jsp:setProperty property="account" value="ben" name="member"/>
<!-- 對名字叫member的物件實體,設定屬性的名稱是account,其值為brad -->
<!-- 整行意同 member.setAccount("brad") -->
<jsp:setProperty property="realname" value="Brad Chao" name="member"/>
<jsp:setProperty property="age" value="18" name="member"/>


<jsp:useBean id="member2" class="w2.tw.brad.beans.Member">	</jsp:useBean>
<jsp:setProperty property="account" value="tony" name="member2"/>
<jsp:setProperty property="realname" value="Tony Stark" name="member2"/>
<jsp:setProperty property="age" value="42" name="member2"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Account: <jsp:getProperty property="account" name="member"/> <br>
Realname: <jsp:getProperty property="realname" name="member"/> <br>
Age: <jsp:getProperty property="age" name="member"/> <br>
<hr>
Account 2: <jsp:getProperty property="account" name="member2"/> <br>
Realname 2: <jsp:getProperty property="realname" name="member2"/> <br>
Age 2: <jsp:getProperty property="age" name="member2"/>
</body>
</html>
<!-- 搭beans.Member,此檔案示範jsp標籤(且可操作物件) -->