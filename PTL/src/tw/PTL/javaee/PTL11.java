package tw.PTL.javaee;
// 搭PTL12, dispatcher的第一招include()
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
		
		String name = request.getParameter("name");	//測試在URL後方帶?name=ladida
		if(name==null)name="World.";
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("PTL12?name="+name); //argument為要去的地方, ?帶參數

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green;'> What up</h1><hr /'>");
		
		dispatcher.include(request, response);		//request.getRequestDispatcher()只是指定他要去的地方, 此處意思為拿request去指定去的地方, 回來時做response前面指定他做的動作
	
		dispatcher = request.getRequestDispatcher("p05.html");//再去其他地方
		dispatcher.include(request, response);	//再include

		
		dispatcher = request.getRequestDispatcher("ptl02.html");
		dispatcher.include(request, response);
		
		dispatcher = request.getRequestDispatcher("ptl02.html");
		dispatcher.include(request, response);
		
		out.println("Hey you! this is the end from PTL11");
	}


}
