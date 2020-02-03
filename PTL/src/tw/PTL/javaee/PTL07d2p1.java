package tw.PTL.javaee;
// 新增一行辨別副檔名
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/PTL07_d2p1")
@MultipartConfig(location = "D:\\Dropboxz\\test1EE\\PTL\\WebContent\\views")
public class PTL07d2p1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String prefix = request.getParameter("prefix");
		System.out.println(prefix);

		int i = 0;

		// 底下處理 enctype="multipart/form-data"
		// **必須加上@MultipartConfig的annotation, 如上方的WebServlet的下一行
		Collection<Part> parts = request.getParts();// Collection沒有順序性
		System.out.println("size = " + parts.size());
		for (Part part : parts) {

			String type = part.getContentType();
			
			String name = part.getName(); // input標籤的name屬性值
			String name1 = part.getSubmittedFileName(); // 含路徑的檔名
			if (name.equals("upload")) {
				if (name1.length() == 0)continue;
				part.write(fileName(prefix, i++));
			}

		}

	}

	private String fileName(String name, int i) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		return name + year + "_" + month + "_" + day + "_" + "0" + i + ".jpg";

	}

}
