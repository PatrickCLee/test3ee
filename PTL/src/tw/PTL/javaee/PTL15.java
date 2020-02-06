package tw.PTL.javaee;
// controller
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL15")
public class PTL15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//step 0 : prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		
		if(x == null) x = "0";
		if(y == null) y = "0";
		if(op== null) op= "1";
		
		
		//step 1 : model
		PTL16 model = new PTL16(x, y, op);
		double result = model.operation();
		
		//2 : view
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher(
				String.format(		//類似sysout.printf的%d, 值, 此處為String的static method回傳String
					"PTL17?x=%s&op=%s&y=%s&result=%s&filename=%s", //此處的順序只需要管此處的format %s傳遞進去的順序就好
						x,op,y,result,"view2.html")); //交給17處理畫面的事
		dispatcher.forward(request, response);
		
	}

}
