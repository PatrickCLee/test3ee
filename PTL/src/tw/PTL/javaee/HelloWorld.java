package tw.PTL.javaee;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

	public HelloWorld() {
		System.out.println("Constructor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init");
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init arguement");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Service");
		super.service(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
	}

}
