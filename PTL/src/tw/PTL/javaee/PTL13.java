package tw.PTL.javaee;
// 搭PTL14, 扮演控制器controller, 接收request 轉發給 model 處理, 拿回處理好的資料 決定送到哪
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL13")
public class PTL13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PTL14"); 

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green;'> What up</h1><hr />");
		
		dispatcher.forward(request, response);	//第二招轉發, 注意頁面顯現出來的是此處設定的html而不是14的純文字
		
	}


}
