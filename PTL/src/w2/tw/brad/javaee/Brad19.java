package w2.tw.brad.javaee;
// 元配,搭BCrypt.java, 新增帳號密碼到資料庫
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import w2.tw.brad.myutils.BCrypt;

@WebServlet("/Brad19")
public class Brad19 extends HttpServlet {
	public Brad19() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//載入驅動, 將mysql-connector-java-8.0.19丟到WebContent的Web-INF的lib底下
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");//此三行會很常見
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		if (account =="" || passwd =="") return;//因先執行網頁,上方兩行從輸入欄抓值回來頂多是空字串,若是先執行servlet因沒直接在URL帶參數就會是null
		
		String hashPW = BCrypt.hashpw(passwd, BCrypt.gensalt()); //產生雜湊值(代表密碼)
		int result = add2MySQL(account, hashPW); //自創method傳入帳號和雜湊值,連接mySql新增進資料庫,回傳異動的行數/筆數
		out.println("add : " + result);
		response.flushBuffer();
	}
	
	private int add2MySQL(String account, String passwd) {
		int ret = 0;
		try {
			Properties prop = new Properties(); //連到資料庫的其中一種方式為,給url和properties,prop又像map,key和value
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);//連到MySQL, jdbc跟mysql講話, mysql跟伺服器講話
			String sql = 
					"INSERT INTO cust (account,passwd) VALUES (?,?)";	//跟MySQL講話,留問號之後再用參數給值
//			Statement stmt = conn.createStatement(); //此兩行會遭隱碼攻擊 故不用
//			stmt.execute(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account); //第一個問號為
			pstmt.setString(2, passwd);	//第二個問號為
			ret = pstmt.executeUpdate();//更新資料庫, 傳回int, 若成功則回傳異動的行數, 否則沒東西
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ret;
	}

}
