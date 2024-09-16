package com.empapp.Entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="email_Id",nullable=false,unique=true)
	private String email;
	
	@Column(name="phnumber",nullable=false,unique=true,length=10)
	private String phnumber;
	
	@Column(name ="salary",nullable=false)
	private int salary;
	
	
	//Create Getter & Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
