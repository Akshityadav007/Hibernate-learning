package com.myProject2.mapping;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
	@Id
	private int rollNo;
	private String name;
	private int marks;
	
//	@OneToOne						// 2)
//	private Laptop laptop;			// 2)

//	public Laptop getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}												// 2)

//	@OneToMany(mappedBy="student")														// 3)		4) added (mappedBy = "student")
//	private List<Laptop> laptop = new ArrayList<Laptop>();			// 3)
//	
//	public List<Laptop> getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(List<Laptop> laptop) {
//		this.laptop = laptop;
//	}																// 3)

	@ManyToMany(mappedBy = "student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
}
