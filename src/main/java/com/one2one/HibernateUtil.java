package com.one2one;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
      
			
			try {
				HibernateUtil hutil=new HibernateUtil();
				ClassLoader classLoader = hutil.getClass().getClassLoader();
		        URL resource = classLoader.getResource("one2one/one2one-cfg.xml");
		        File file = new File(resource.toURI());
				System.out.println(file.getPath());
				sessionFactory=new Configuration().configure(file).buildSessionFactory();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}

}
