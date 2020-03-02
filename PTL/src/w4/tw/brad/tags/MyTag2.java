package w4.tw.brad.tags;
//scriptless(jsp)的寫法body內不可以寫jsp,可以寫html
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag2 extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody(); //拿到真正的body物件(標籤的body)
		
		StringWriter swriter = new StringWriter();//透過writer處理,此為java.io的物件實體
		body.invoke(swriter);		//body裡面的內容是經過swriter負責處理	
		System.out.println(swriter.toString());	//swriter擁有body裡所有的內容,在console中先看內容
		
		out.println("Hello, " + swriter.toString().toUpperCase());
	}
}
