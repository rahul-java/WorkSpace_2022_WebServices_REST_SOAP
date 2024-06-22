
public class RequestHandlerSOA 
{

	public String getFactorial(String n)
	{
		int no=Integer.parseInt(n);
		int f=1;
		if(no==1||no==0)
		{
			return "Result is : "+f;
		}
		else
		{
			for(int i=no;i>1;i--)
			{
				f=f*i;
			}
			return "Result is : "+f;
		}
	}
}
