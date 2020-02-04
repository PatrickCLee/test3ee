package tw.PTL.javaee;
// 搭p03p1 網頁端上傳多個檔案 以現在日期時間為檔名存到電腦
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

@WebServlet("/PTL07")
@MultipartConfig(location="D:\\Dropboxz\\test3ee\\PTL\\WebContent\\upload")
public class PTL07 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 底下處理 enctype="multipart/form-data"	
		// **必須加上@MultipartConfig的annotation, 如上方的WebServlet的下一行
		Collection<Part> parts = request.getParts();
		System.out.println("size = " + parts.size());
		for(Part part : parts) {
			
			String name = part.getName();	//input標籤的name屬性值
			String name1 = part.getSubmittedFileName();	//含路徑的檔名
			
			
			part.write(fileName(i++));	//用此直接把上傳的檔案寫到輸入的參數位置
			

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
