package com.myProject5.HbObjectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		session.beginTransaction();
		
//		Laptop l = new Laptop();									// 1)
//		l.setLid(51);												// 1)
//		l.setBrand("Hp");											// 1)
//		l.setPrice(50000);											// 1)
//		
//		session.save(l);											// 1)
//		l.setPrice(45000);											// 1)  this data is feed because 
		
//		Laptop lap = (Laptop) session.get(Laptop.class, 51);		// 2) get() method
//		System.out.println(lap);									// 2)
		
		Laptop lap = (Laptop) session.load(Laptop.class, 51);		// 3) load() method
		System.out.println(lap);									// 3)
		
		session.getTransaction().commit();
		
	}
}
