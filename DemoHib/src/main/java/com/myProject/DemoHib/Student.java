package com.myProject.DemoHib;

import javax.persistence.*;

@Entity //(name="Student_details")	 // this name is meant to give aliases to entity(						             // this @Entity defines the class as an entity to store it's objects in the db	
public class Student {
	
	@Id												// this @Id defines the primary key
	private int id;
//	private String name;
	private StudentName sName;						// 3)
	public StudentName getsName() {
		return sName;
	}

	public void setsName(StudentName sName) {
		this.sName = sName;
	}

	//@Column(name="dept_name")
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sName=" + sName + ", department=" + department + "]";
	}

	
}
