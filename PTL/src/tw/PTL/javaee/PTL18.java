package tw.PTL.javaee;
//到webContent底下的we-inf底下的web.xml
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL18")
public class PTL18 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();//代表的是整個servlet的環境
		String viewPath = context.getInitParameter("viewPath");//取得初始設定, 之後方便維護, 只要更改web.xml就可以更改全部
		System.out.println(viewPath);
		
	}


}
