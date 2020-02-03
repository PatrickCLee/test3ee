package tw.PTL.javaee;
// 搭配ptl03p1 網頁端上傳多個檔案 下載下來後自定檔名
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

@WebServlet("/PTL07p2")
@MultipartConfig(location="D:\\Dropboxz\\test1EE\\PTL\\WebContent\\views")
public class PTL07p2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// D:/Dropboxz/test1EE/PTL/WebContent/upload	存放使用者丟上來東西的路徑
		File uploadDir = new File("D:\\Dropboxz\\test1EE\\PTL\\WebContent\\views");
		
		// 底下處理 enctype="multipart/form-data"	
		// **必須加上@MultipartConfig的annotation, 如上方的WebServlet的下一行
		Collection<Part> parts = request.getParts();
		System.out.println("size = " + parts.size());
		for(Part part : parts) {
			
			String name = part.getName();	//input標籤的name屬性值
			String name1 = part.getSubmittedFileName();	//含路徑的檔名
			
			
			part.write(fileName(i++));
			

		}
	}
	int i=1;

	private String fileName(int i) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		return "F" + year + "_" + month + "_" + day + "_" + "0" + i + ".jpg";
		
	}

}
