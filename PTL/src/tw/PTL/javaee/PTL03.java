package tw.PTL.javaee;
//搭配ptl03測試
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL03")
public class PTL03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//確保編碼正常, 中文可顯示
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String area = request.getParameter("area");
		String memo = request.getParameter("memo");
		
		System.out.println(account + ":" + passwd + ":" + gender + 
				":" + area + ":" + memo);

		//		String like = request.getParameter("like"); //只會顯示第一個
		String[] likes = request.getParameterValues("likes");//取得該參數所有的values
		if(likes!=null) {
			for(String like : likes) {
				System.out.println(like);
			}			
		}
		
		
		
		
	}

}