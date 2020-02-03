package tw.PTL.javaee;
//response, 09進階版, 把ptl04的結果顯示在原頁面上
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL10")
public class PTL10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
	
		//若使用者未輸入就按下submit, x和y會是null, 故新增下列10行 
		int intx, inty; 
		double result;
		result = intx = inty = 0;	//**若寫為intx = result = 0;會出錯
		
		
		if(x!=null) {
			try {
				intx = Integer.parseInt(x);
				inty = Integer.parseInt(y);
				result = intx + inty;
				switch(op) {
					case "1": result = intx + inty;break;
					case "2": result = intx - inty;break;
					case "3": result = intx * inty;break;
					case "4": result = intx*1.0 / inty;break;
				}
			}catch(Exception e) {}
		}
		
		if(op==null)op="1";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.append("<h1>What up</h1>")
		.append("<form action='PTL10' method='get'>")
		.append("<input type='text' name='x'value="+intx+ ">")
		.append("<select name='op'>")
		.append("<option value='1' "+((op.equals("1"))?"selected":"") + " >+</option>")//**此行重要 ((op.equals("1"))?"selected":"")
		.append("<option value='2' "+((op.equals("2"))?"selected":"") + " >-</option>")
		.append("<option value='3' "+((op.equals("3"))?"selected":"") + " >x</option>")
		.append("<option value='4' "+((op.equals("4"))?"selected":"") + " >/</option>")
		.append("</select>")
		.append("<input type='text' name='y'value="+inty+ ">")
		.append("<input type='submit' value='=' />")
		.append(" " + result)
		.append("</form>");
		response.flushBuffer();
		
	}

}
