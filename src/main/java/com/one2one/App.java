package com.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

	void saveData() {
		
		Employee emp=new Employee();
		emp.setEmpid(101);
		emp.setEmpName("krishna");
		Department dept=new Department();
		dept.setDeptId(2001);
		dept.setDeptName("Developer");
		emp.setDepartment(dept);
		SessionFactory sfactory = HibernateUtil.getSessionFactory();
		Session session = sfactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(emp);  //save or saveOrUpdate,update,delete or merge

		tx.commit();
		session.close();
	}

	void fetchData(int empId) {
		SessionFactory sfactory = HibernateUtil.getSessionFactory();
		Session session = sfactory.openSession();
		Employee emp = session.get(Employee.class, empId);// get or load method can use to fetch data
		                                                 
		System.out.println(emp);
		session.close();
	}

	public static void main(String[] args) {
		App app=new App();

//		app.saveData();
		
		app.fetchData(101);

	}

}
