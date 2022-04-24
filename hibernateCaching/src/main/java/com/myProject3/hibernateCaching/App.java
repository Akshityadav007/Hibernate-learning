package com.myProject3.hibernateCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
        Student s = null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
	/*	Session session = sf.openSession();						// 1)
		session.beginTransaction();
		
		s = (Student) session.get(Student.class,101);			// 2)
		System.out.println(s);									// 2)
		
//		s = (Student) session1.get(Student.class,102);			// 3)
//		System.out.println(s);									// 3)
		 
		s = (Student) session.get(Student.class,101);			// 4)
		System.out.println(s);									// 4)
		
		session.getTransaction().commit();
		
		*/               										// 1)
		
		Session session1 = sf.openSession();					// 5)
		session1.beginTransaction();							// 5)
		
		s = (Student) session1.get(Student.class, 100);			// 5)
		System.out.println(s);									// 5)
		
		session1.getTransaction().commit();						// 5)
		session1.close();										// 5)
		
		Session session2 = sf.openSession();					// 5)
		session2.beginTransaction();							// 5)
		
		s = (Student) session2.get(Student.class, 100);			// 5)
		System.out.println(s);									// 5)
		
		session2.getTransaction().commit();						// 5)
		session2.close();										// 5)

    }
}
