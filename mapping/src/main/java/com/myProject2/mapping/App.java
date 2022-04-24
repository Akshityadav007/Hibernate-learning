package com.myProject2.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {
	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(001);
		laptop.setLname("Hp");
		
		Student s = new Student();
		s.setName("Rahul");
		s.setRollNo(10);
		s.setMarks(59);
	//	s.setLaptop(laptop);       // 2)			use 'create' property in hibernate.cfg.xml this time
		s.getLaptop().add(laptop);			// 3)	use 'create' property in hibernate.cfg.xml this time too  // this line is used in 4) & 5) too don't remove it

		laptop.getStudent().add(s);				// 5)
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);	// make sure to annote both classes
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(laptop);
		session.save(s);
		 
		// before running please make sure you don't have tables with same name in same workspace in other projects... if so, drop tables in mysql workbench in those databases
		
		session.getTransaction().commit();
	}
}
