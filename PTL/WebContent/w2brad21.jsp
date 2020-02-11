<%
// 	String name = request.getParameter("name");	//會出現例外,區域變數名稱重複,代表用include可抓到參數
	String lottery = (String)(request.getAttribute("lottery"));
%>

<div style="background-color:rgb(255,255,0);">
Hello, <%= name %>.<br>
==> <%= lottery %><br>
<%= (String)(pageContext.getAttribute("key1")) %>
</div>
<!-- 搭20 -->