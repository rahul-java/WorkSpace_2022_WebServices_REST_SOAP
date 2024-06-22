package sub;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class SubtractClass extends TagSupport{

	int n1;
	int n2;
	
	public void setN1(String n1) {
		this.n1 = Integer.parseInt(n1);
	}
	public void setN2(String n2) {
		this.n2 = Integer.parseInt(n2);
	}
	
	@Override
	public int doStartTag()  {
		// TODO Auto-generated method stub
		try {
			JspWriter out = pageContext.getOut();
			out.println("Subtraction is : "+(n1-n2));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Tag.SKIP_BODY;
	}
}
