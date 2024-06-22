package max;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class FactorialClass extends TagSupport{
	
	int fn;

	public void setFn(String fn) {
		this.fn = Integer.parseInt(fn);
	}


public int doStartTag() {
	// TODO Auto-generated method stub
	
	int f=1;
	try {
		JspWriter out = pageContext.getOut();
		if(fn==1||fn==0)
		{
			out.println("Result is :  "+f);
		}
		else
		{
			for(int i=fn;i>1;i--)
			{
				f*=i;
			}
			out.println("Result is :  "+f);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Tag.SKIP_BODY;
}
	

}
