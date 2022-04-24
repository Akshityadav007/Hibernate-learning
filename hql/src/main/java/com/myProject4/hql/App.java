package com.myProject4.hql;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		session.beginTransaction();
//		Random r = new Random();  			// used to provide random numbers					1)
//		
//		for(int i =1;i <= 50;i++) {															//	1)
//			Student s = new Student();														//  1)
//			s.setRollNo(i);																	//  1)
//			s.setName("Name " + i);															//  1)	
//			s.setMarks(r.nextInt(100));  	// this will provide random numbers upto 100		1)
//			session.save(s);
//		}																					//	1)
		
//		Query q = session.createQuery("from Student where rollNo=23");						//  2)			// 3) added where marks > 50	// this line is used in 2) & 3) & 4)
//		List<Student> students = q.list();													//  2)
//		
//		for(Student s: students) {
//			System.out.println(s);
//		}
		
//		Student student = (Student) q.uniqueResult();										//  4)
//		System.out.println(student);														//  4)
		 
		
		Query q = session.createQuery("select rollNo,name,marks from Student");				//  5) 		// select * won't work
		
		List<Object[]> students = (List<Object[]>) q.list();								//  5)
		
		for(Object[] student : students) {													//  5)
			System.out.println(student[0] + " : " + student[1] + " : " + student[2]);		//  5)
		}																					//  5)
		
		
		session.getTransaction().commit();										
	
    }
}
