package w4.tw.brad.tags;
//要做tag類別必須extends SimTag及override doTag()
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag1 extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspContext context = getJspContext();	//像是剛才的tag也是用JspContext寫
		JspWriter out = context.getOut();		//拿到 JspWriter就可輸出
		out.println("Hello, Me");
		
		
	}
}
