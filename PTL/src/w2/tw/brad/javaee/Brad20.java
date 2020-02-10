package w2.tw.brad.javaee;
// 元配, 搭BradAPIs, 調換get和post的呼叫對象, 使用帳號密碼登入
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad20")
public class Brad20 extends HttpServlet {
	private static final String sql = 	//從下方移到這
			"SELECT * FROM cust WHERE account = ?";//在資料庫中找帳號看是否存在
	private static  PreparedStatement pstmt;	//從下方移到這
	private boolean isMysqlOK;	//連線資料庫成功與否
	
	
	public Brad20() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//載入驅動, 
			Properties prop = new Properties();	//偷19
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop); //連線
			pstmt = conn.prepareStatement(sql);
			isMysqlOK = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");//此三行會很常見
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		if (account == null || !isMysqlOK) {	//帳號錯或是連線資料庫失敗
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Busy!");//第一個參數為連線狀態碼, 第二為欲顯示訊息 
			return;
		}
		
		boolean isAccountOK = checkAccount(account, passwd);//自創method帶入帳號密碼,回傳boolean
		if (isAccountOK) {
			out.println("OK");
			response.sendRedirect("w2main.html");
		}else {
			response.sendRedirect("w2brad20.html");
		}
	}

	private boolean checkAccount(String account, String passwd) {
		boolean isPWOK = false;
		try {
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery(); //查詢資料, 傳回結果物件 (在此假設我們有將資料庫的account欄位設為唯一)
			if (rs.next()) {	//指標概念, 如果有資料, 此處意即輸入的account在資料庫有資料
				String hashPW = rs.getString("passwd");//拿到資料庫中的passwd欄位傳回值
				isPWOK = BradAPIs.chPassword(passwd, hashPW);//將使用者輸入的密碼和資料庫中此帳號的雜湊值傳給method,丟出去普通類別驗證密碼是否吻合(因為還要用別人寫好的method,故先連到普通類別再接過去)
			}
		} catch (Exception e) {

		}
		return isPWOK;
	}
	
}
