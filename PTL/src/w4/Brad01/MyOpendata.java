package w4.Brad01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyOpendata {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "root");
			info.put("serverTimezone", "Asia/Taipei");
			
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/iii",info);
			String sql =
				"INSERT INTO opendata (cname,address,tel,latlng,picurl) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = 
				conn.prepareStatement(sql);
			
			//-----------------

			URL url = new URL(
					"https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection hconn = 
					(HttpURLConnection)url.openConnection();
			hconn.connect();
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(hconn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while( (line = reader.readLine()) !=null ) {
				sb.append(line);
			}
			
			reader.close();
			
			
			// ----- parse JSON 解析JSON
			String json = sb.toString();
			JSONArray root = new JSONArray(json);
			System.out.println(root.length());
			
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				pstmt.setString(1, row.getString("Name"));	//row拿到的是從opendata上抓到的項目,大小寫嚴格區分
				pstmt.setString(2, row.getString("Address"));
				pstmt.setString(3, row.getString("Tel"));
				pstmt.setString(4, row.getString("Coordinate"));
				pstmt.setString(5, row.getString("PicURL"));
				pstmt.executeUpdate();		//解出一筆insert一筆
			}
			
			
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
