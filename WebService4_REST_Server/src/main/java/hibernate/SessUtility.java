package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessUtility {
	private SessUtility()
	{}
	private static SessionFactory sf;
	static ThreadLocal<Session> ss=new ThreadLocal<Session>();
static
{
	 Configuration conf = new Configuration();
	 conf.configure("/hibernate/hibernate.cfg.xml");
	 sf = conf.buildSessionFactory();
}

public static Session getSesss()
{
	Session s = ss.get();
	if(s==null)
	{
		s=sf.openSession();
		ss.set(s);
	}
	return s;
}

public void closeSessionn()
{
	Session s = ss.get();
	if(s!=null)
	{
		ss.set(null);
	}
}


}
