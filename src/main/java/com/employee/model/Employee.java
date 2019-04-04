package com.employee.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.employee.validator.UniqueUser;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@UniqueUser
	private String name;

	private String emailId;
	private String contactNo;

	public Employee() {

	}

	public Employee(int id, String name, String emailId, String contactNo) {
		//super();
		Objects.requireNonNull(name, "name cannot be null");
		Objects.requireNonNull(emailId, "emailId cannot be null");
		Objects.requireNonNull(contactNo, "conatctNo cannot be null");
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.contactNo = contactNo;
	}

	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getEmailId() { return emailId; }
	 * 
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 * 
	 * public String getContactNo() { return contactNo; }
	 * 
	 * public void setContactNo(String contactNo) { this.contactNo = contactNo; }
	 * 
	 * @Override public String toString() { return "Employee [id=" + id + ", name="
	 * + name + ", emailId=" + emailId + ", contactNo=" + contactNo + "]"; }
	 */
}
