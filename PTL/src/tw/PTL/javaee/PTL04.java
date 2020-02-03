package tw.PTL.javaee;
//InputS讀圖檔款	同時有檔案上傳及輸入欄的表單
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL04")
public class PTL04 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		InputStream in = request.getInputStream();
		byte[] buf = new byte[4096]; int len;
		while((len = in.read(buf)) != -1) {
			System.out.println(new String(buf, 0, len));
		}
		in.close();
		
		System.out.println("---------");
		String ok = request.getParameter("ok");
		System.out.println(ok);
	}
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
