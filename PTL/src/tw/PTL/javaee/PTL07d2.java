package tw.PTL.javaee;
// 元配, 在 以網頁中輸入欄來設定檔名 的前提下寫code
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

@WebServlet("/PTL07d2")
@MultipartConfig(location = "D:\\Dropboxz\\test3ee\\PTL\\WebContent\\upload")
public class PTL07d2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String prefix = request.getParameter("prefix"); //先抓到這個key的value, 單字prefix, 字首/詞頭
		System.out.println(prefix);

		int i = 0;

		// 底下處理 enctype="multipart/form-data"
		// **必須加上@MultipartConfig的annotation, 如上方的WebServlet的下一行
		Collection<Part> parts = request.getParts();// Collection沒有順序性, 故上方要先把value抓出來, 丟進來的檔案才有名字可以參照
		System.out.println("size = " + parts.size());
		for (Part part : parts) {

			String name = part.getName(); // input標籤的name屬性值
			String name1 = part.getSubmittedFileName(); // 含路徑的檔名
			if (name.equals("upload")) {	//排除掉非檔案上傳的東西
				if (name1.length() == 0)continue;	//以防該input沒有含檔案(多個檔案上傳按鈕但user沒有全部使用到)
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
