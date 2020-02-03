package tw.PTL.javaee;
// view
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL17")
public class PTL17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		String x = request.getParameter("x");
		String op = request.getParameter("op");
		String y = request.getParameter("y");
		String result = request.getParameter("result");
		String filename = request.getParameter("filename");
		
		String op1 = op.equals("1")?"selected":"";	//分開做比較直覺
		String op2 = op.equals("2")?"selected":"";
		String op3 = op.equals("3")?"selected":"";
		String op4 = op.equals("4")?"selected":"";
		
		String html = loadView(filename);	//丟到下面寫method
		out.print(String.format(html, x,op1,op2,op3,op4,y,result));
		response.flushBuffer(); //如果不flush若頁面資料很多, 最末端的地方可能不會跑出來
		
	}

	private String loadView(String filename) {
		ServletContext context = getServletContext();
		String viewPath = context.getInitParameter("viewPath");
		
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = 
					new BufferedReader(
							new FileReader(
									new File(viewPath, filename)));
			String line;
			while((line=reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return sb.toString();
	}
	
}
