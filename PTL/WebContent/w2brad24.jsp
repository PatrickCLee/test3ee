<%
	String name = request.getParameter("name");
	if (name == null) name = "World";
	
	String value1 = request.getParameter("key1");
	String value2 = request.getParameter("key2");
%>
Hello, <%= name %><br>
<%= value1 %><br>
<%= value2 %>
<!-- 搭23 -->