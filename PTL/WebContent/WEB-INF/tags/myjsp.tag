<%@ tag import="java.util.*" %>
<%-- 這裡是tag所以是 tag,平常在jsp檔裡面寫的是page --%>
<%@ tag dynamic-attributes="product" %>

<%--此一個標籤代表一個產品 --%>

<% 
	HashMap<String,String> ps = 
		(HashMap<String,String>)jspContext.getAttribute("product");//在jsp檔裡面稱為pageContext,在tag裡稱為jspContext
	out.println("<tr>");
	
	out.println("<td>");
	out.println(ps.get("name"));
	out.println("</td>");

	out.println("<td>");
	out.println(ps.get("price"));
	out.println("</td>");
	
	out.println("</tr>");

%>