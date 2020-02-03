package tw.PTL.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL12")
public class PTL12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //因11已有寫, 拿12過去時就重複了, 視情況刪去
		
		String name = request.getParameter("name");	//接收11問號帶的參數
		
		PrintWriter out = response.getWriter();
		out.println("Hello" + name + "I'm 12!<hr / style='width:80%';>");
	}

}
