package max;

public class RequesthandlerSOA {
	public String getFacto(String no)
	{   int f=1;
		int n = Integer.parseInt(no);
		if(n==0 && n==1)
			return "Result is "+f;
		else
		{
			for(int i=n;i>1;i--)
			{
				f=i*f;
			}
			return "Result is "+f;
		}
	}
	
	
	public User getUserDetail()
	{
		User usr = new User();
		usr.setUid(10);
		usr.setName("bala");
		return usr;
	}
	
	public String gettt()
	{
		return "hello";
	}

}
