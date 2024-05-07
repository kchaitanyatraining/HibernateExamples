package com.basic;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
	
		App app=new App();
		
		ClassLoader classLoader = app.getClass().getClassLoader();
        URL resource = classLoader.getResource("basic/basic-cfg.xml");
        try {
			File file=new File(resource.toURI());
			System.out.println(file.getPath());
			SessionFactory factory=new Configuration().configure(file).buildSessionFactory();
			Session session=factory.openSession();
		org.hibernate.Transaction tx=	session.beginTransaction();
			User user=new User();
			user.setUserId(1001);
			user.setUserName("krishna");
			LocalDate localDate = LocalDate.now();
			Date sqlDate = Date.valueOf(localDate);
			user.setDob(sqlDate);
			session.save(user);
			tx.commit();
			session.close();
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		URL resource =App.class.getClassLoader().getResource("basic/baisc-cfg.xml");
//		 File file = new File(resource.getFile());
//		 
//		 
//		SessionFactory factory=new Configuration().configure().buildSessionFactory();
//		Session session=factory.openSession();
//		
//		
//		session.close();
//		factory.close();
	}

}
