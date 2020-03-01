<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if (session.isNew() ||
			request.getParameter("account") == null ||
			request.getParameter("passwd") == null){
		//來亂的
		response.sendRedirect("w4brad53.jsp");
		return;
	}
	
	String account = request.getParameter("account");
	String passwd = request.getParameter("passwd");
	if (account.equals("brad") && passwd.equals("123")){
		// Login Success
		session.setAttribute("account", account);	//此處第二參數通常為資料庫物件,帶有會員整個資料
		response.sendRedirect("w4brad55.jsp");
	}else{
		// Login failure	可以帶參數回去顯示帳密錯誤
		response.sendRedirect("w4brad53.jsp");
	}

%>

