package tw.PTL.javaee;
// 不搭, 開始研究response, charSequence 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL08")
public class PTL08 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8"); //轉換為html
		PrintWriter out = response.getWriter(); //看PW的api的append()parameter是帶charSequence, 但write()是帶String, StringBuffer和StringBuilder也有實做charSequence
		out.println("Hello, World1<br>");
		out.println("Hello, World2");
//		out.append("a")		//charSequence
//		.append("bc")
//		.append("def");
		//System.out.println();
	}
}
