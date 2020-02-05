package tw.PTL.javaee;
// 元配, get或post
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PTL02")
public class PTL02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();	//拿到參數, 假設key(input的name)可能重複, 用傳回map的這招(value為陣列)
		Set<String> keys = map.keySet(); 		//抓到所有的key
		System.out.println("new->>>>>>>>>>>>>");
		for (String key : keys) {
			String[] values = map.get(key);
			System.out.print(key + ":");
			for(String value : values) {
				System.out.println(value);
			}
			System.out.println("-----");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
