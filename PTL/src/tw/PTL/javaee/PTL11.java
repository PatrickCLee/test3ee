package tw.PTL.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL11")
public class PTL11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		if(name==null)name="World.";
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("PTL12?name="+name); //argument為要去的地方, ?帶參數

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green;'> What up</h1><hr / style='width:50%;'>");
		
		dispatcher.include(request, response);	//dispatcher主要做兩種事, include及forward
	
		dispatcher = request.getRequestDispatcher("ptl05.html");//再去其他地方
		dispatcher.include(request, response);
		
		out.println("Hey you!<hr />");
	}


}
