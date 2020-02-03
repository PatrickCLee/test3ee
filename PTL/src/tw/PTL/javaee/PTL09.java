package tw.PTL.javaee;
//response, 搭配ptl04, 計算
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL09")
public class PTL09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int intx = Integer.parseInt(x);
		int inty = Integer.parseInt(y);
		int result = intx + inty;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(intx + " + " + inty + " = " + result);
		response.flushBuffer();
	}


}
