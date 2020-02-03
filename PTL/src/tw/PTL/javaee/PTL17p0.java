package tw.PTL.javaee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// view
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL17p0")
public class PTL17p0 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		String html = loadView();
		out.print(html);
		response.flushBuffer(); //如果不flush若頁面資料很多, 最末端的地方可能不會跑出來
		
	}

	private String loadView() {
		ServletContext context = getServletContext();
		String viewPath = context.getInitParameter("viewPath");
		try {
			BufferedReader reader = 
					new BufferedReader(
							new FileReader(
									new File(viewPath, "view1.html")));
			reader.close();
		} catch (Exception e) {
		}
		return "<h1>PTL</h1>";
	}
	
}
