<%@ tag import="java.util.*" %>
<%-- 這裡是tag所以是 tag,平常寫的jsp是page --%>
<%@ tag dynamic-attributes="product" %>
<% 
	HashMap<String,String> ps = 
		(HashMap<String,String>)jspContext.getAttribute("product");
	out.println("<tr>");
	
	out.println("<td>");
	out.println(ps.get("name"));
	out.println("</td>");

	out.println("<td>");
	out.println(ps.get("price"));
	out.println("</td>");
	
	out.println("</tr>");

%>