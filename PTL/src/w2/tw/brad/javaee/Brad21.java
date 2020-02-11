package w2.tw.brad.javaee;
// 不搭, 後端處理影像,BufImage搭G2D畫圖
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad21")
public class Brad21 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String srate = request.getParameter("rate");
		if (srate == null) return;
		float rate = 0;
		try {
			rate = Float.parseFloat(srate);
		} catch (Exception e) {

		}
		
		BufferedImage bimg = new BufferedImage(
				400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bimg.createGraphics();
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, bimg.getWidth(), bimg.getHeight());
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(bimg.getWidth()*rate/100), bimg.getHeight());
		
		OutputStream oout = response.getOutputStream();//到網頁上輸出,因此接到response的水管
		ImageIO.write(bimg, "jpeg", oout);//第三個param為水管
		oout.flush();
		oout.close();
	}

}
