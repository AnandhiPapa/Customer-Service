package com.demo.dto;

import java.util.Date;

public class CustomerDTO {
	private int Id;
	private String Name;
	private String gender;
	private String email;
	private int ContactNumber;
	private Date CreatedAt;
	private Date UpdatedAt;
	public int getId() {
		return Id;}
		

	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public Date getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerDTO [Id=" + Id + ", Name=" + Name + ", gender=" + gender + ", email=" + email
				+ ", ContactNumber=" + ContactNumber + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + "]";
	}
	
	
	
}