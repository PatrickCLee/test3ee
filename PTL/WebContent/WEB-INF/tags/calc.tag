<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="x" required="true" %>
<%@ attribute name="y" required="true" %>

<%@ variable name-given="add" %>
<%@ variable name-given="sub" %>
<%@ variable name-given="multiply" %>
<%@ variable name-given="divide" %>
<%-- 宣告變數,name-given是對外輸出的變數 --%>

<%-- 下方為區域變數 --%>
<c:set var="add" value="${x + y }" />
<c:set var="sub" value="${x - y }" />
<c:set var="multiply" value="${x * y }" />
<c:set var="divide" value="${x / y }" />
<jsp:doBody />
<%-- 此處的body為jsp的body,也是innerHTML(js取得元素)的那種形式 --%>