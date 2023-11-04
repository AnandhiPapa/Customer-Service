package com.demo.entity;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({@NamedQuery (name = "Customer.findAllOrderByNameDescending" , query = "select a from Customer  a ORDER BY a.name DESC")})

public class Customer {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
     
      @Column(unique=true,name = "Customer_name")
      private String name;
      
      @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "Customer")
      private List<Stock> Stock;
      
      @Column(name="email")
      private String email;
      
      
      @Column(name="Gender")
      private String Gender;
      
     
      @Column(name="contact_number")
      private int contactNumber;
      
      
      @Column(nullable = false,updatable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @CreatedDate
      private Date createdAt;
      
      @Column(nullable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @LastModifiedDate
      private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stock> getStock() {
		return Stock;
	}

	public void setStock(List<Stock> stock) {
		Stock = stock;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int i) {
		this.contactNumber = i;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Stock=" + Stock + ", email=" + email + ", Gender=" + Gender
				+ ", contactNumber=" + contactNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
      
}
	