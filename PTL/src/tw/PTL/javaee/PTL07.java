package tw.PTL.javaee;
// 直接指定上傳路徑(在annotation後方括號)
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/PTL07")
@MultipartConfig(location="D:\\Dropboxz\\test1EE\\PTL\\WebContent\\views")
public class PTL07 extends HttpServlet {

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
			System.out.println(name + ":" + name1);
			
			part.write(name1);
			
//			InputStream in = part.getInputStream();	//銜接實際的檔案內容
//			byte[]buf = new byte[(int)part.getSize()];
//			in.read(buf);
//			in.close();
//			FileOutputStream fout = new FileOutputStream(new File(uploadDir, name1));
//			fout.write(buf);
//			fout.flush();
//			fout.close();
		}
	}

}
