package com.one2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

	void saveData() {
		SessionFactory sfactory = HibernateUtil.getSessionFactory();
		Session session = sfactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		

		Cart cart = new Cart();
		cart.setName("cart1");
		session.save(cart);
		
		Item item1 = new Item();
		item1.setName("item1");
		item1.setPrice(100);
		item1.setCart(cart);
		session.save(item1);
		
		Item item2 = new Item();
		item2.setName("item2");
		item2.setPrice(200);
		item2.setCart(cart);
		session.save(item2);
		tx.commit();
		session.close();
	}

	void fetchData() {
		SessionFactory sfactory = HibernateUtil.getSessionFactory();
		Session session = sfactory.openSession();
		// Item item = session.get(Item.class, id);
		Query query = session.createQuery("From Item t  left join   t.cart c");

		List list = query.getResultList();
		System.out.println(list);
		session.close();
	}

	public static void main(String[] args) {
		App app = new App();
		//app.saveData();
		app.fetchData();

	}

}
