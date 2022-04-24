package com.myProject.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		
		StudentName sn = new StudentName(); 				// 3) creating an object of StudentName class
		sn.setfName("Rahul");								// 3)
		sn.setmName("Kumar");								// 3)
		sn.setlName("Singh");								// 3)
												
		Student st = new Student();
//		st.setName("Bhola");										// 1)
//		st.setId(005);
//		st.setDepartment("Computer Science and Engineering");
		
		st.setsName(sn);
		st.setId(001);
		st.setDepartment("ECE");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); 		// 1) addAnnotedClass specifies the class to be used  // inside configure() we can pass our custom file name if assigned a name to .cfg file instead hibernate.cfg.xml
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 		// 1.2) building our service registry using con object which contains the configurations
		
		SessionFactory sf = con.buildSessionFactory(reg);							// 1)
		
		Session session = sf.openSession();											// 1)
		
		Transaction tx = session.beginTransaction();   // 1) we need to follow ACID properties
		
		session.save(st);						// 1) to store data we use save method
		
		//st = (Student) session.get(Student.class,001);		// 2) to fetch data
		
		tx.commit();																// 1)
		
		//System.out.println(st);						// 2) to print the fetched data
	}
}
