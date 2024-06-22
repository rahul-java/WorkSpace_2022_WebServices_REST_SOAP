package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerClass implements ServletContextListener , HttpSessionListener , ServletRequestListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
	}
@Override
public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	System.out.println("contextDestroyed");
}

@Override
public void sessionCreated(HttpSessionEvent se) {
	// TODO Auto-generated method stub
	System.out.println("sessionCreated");
}

@Override
public void sessionDestroyed(HttpSessionEvent se) {
	// TODO Auto-generated method stub
	HttpSession session = se.getSession();
	String amount=(String)session.getAttribute("amt");   
	System.out.println("Session Out : "+amount);
	
	System.out.println("sessionDestroyed");
}

@Override
public void requestInitialized(ServletRequestEvent sre) {
	// TODO Auto-generated method stub
	System.out.println("requestInitialized");
}

@Override
public void requestDestroyed(ServletRequestEvent sre) {
	// TODO Auto-generated method stub
	System.out.println("requestDestroyed");
}
}
