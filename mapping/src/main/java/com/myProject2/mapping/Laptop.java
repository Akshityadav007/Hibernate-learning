package com.myProject2.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String lname;
	
//	@ManyToOne							// 4)
//	private Student student;			// 4)
//
//	public Student getStudent() {
//		return student;
//	}	
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}												// 4)

	@ManyToMany														// 5)
	private List<Student> student = new ArrayList<Student>();		// 5)
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}																	// 5)

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
