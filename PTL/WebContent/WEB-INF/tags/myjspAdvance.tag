<%@ tag import="java.util.*" %>
<%@ tag dynamic-attributes="shop" %>

<%--此一個標籤代表一個店家 --%>

<% 
	HashMap<String,String> ps = 
		(HashMap<String,String>)jspContext.getAttribute("shop");
	out.println("<tr>");
	
	out.println("<td>");
	out.println(ps.get("name"));
	out.println("</td>");

	out.println("<td>");
	out.println("<img src='");
	out.println(ps.get("pic"));
	out.println("' height='95' width='200'>");
	out.println("</td>");
	
	out.println("</tr>");

%>