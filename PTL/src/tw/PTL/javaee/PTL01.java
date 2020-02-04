package tw.PTL.javaee;
//搭ptl01, HttpServlet是介面, 我們在做的是多型, 寫出提供服務的servlet
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL01")
public class PTL01 extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Enumeration<String> headers = request.getHeaderNames();	//看header, 因不知道會傳哪些key, 故用回傳Enum的method
		while (headers.hasMoreElements()) {
			String key = headers.nextElement();		//回傳key (對header來說正確名稱是name)
			String value = request.getHeader(key);	//用傳回的key取得value
			System.out.println(key + " = " + value);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
