package w2.tw.brad.javaee;
// 21進階,將本地端圖片加上浮水印,輸出成檔案或僅在瀏覽器顯示圖片
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad22")
public class Brad22 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage bimg = ImageIO.read(new File("D:/Dropboxz/test3ee/PTL/WebContent/upload/alex.jpg"));
		Graphics2D g2d = bimg.createGraphics();
		
		Font myfont = new Font(null, Font.BOLD + Font.ITALIC, 30);
		
		AffineTransform tran = new AffineTransform();//創一個代表變形transformation的物件
		tran.rotate(Math.toRadians(-45));	//變形(此處為單純角度上的旋轉),裡面再用Math的method讓我們可簡單定義需要的角度
		Font font2 = myfont.deriveFont(tran);	//將原先設定好的font加上變形,回傳新的font
		
		g2d.setFont(font2);
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Hello, World", 80, 150);
		
		//response.setContentType() 此設定敘述句不會疊加, 依最後設定為準
		response.setContentType("text/html; charset=UTF-8");//此處不設也可輸出檔案,但設為此是因成功存檔後可顯示已成功儲存
		FileOutputStream fout = new FileOutputStream(new File("D:/Dropboxz/test3ee/PTL/WebContent/upload/newAlex.jpg"));		
		ImageIO.write(bimg, "jpeg", fout);
		fout.flush();
		fout.close();
	
		response.setContentType("image/jpeg");	//此處不設也可顯示畫面,但保險起見
		OutputStream oout = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", oout);
		oout.flush();
		oout.close();
	}

	

}
