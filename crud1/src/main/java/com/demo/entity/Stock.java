package com.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Stock {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int StockId;
     
     @Column(name="Stockdetails")
     private String Stockdetails;
     
    
     @Column(name="Stock_status")
     private String status;
     
     
     @Column(nullable = false,updatable = false)
     @Temporal(TemporalType.TIMESTAMP)
     @CreatedDate
     private Date createdAt;
     
     @Column(nullable = false)
     @Temporal(TemporalType.TIMESTAMP)
     @LastModifiedDate
     private Date updatedAt;
     
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "customerid",nullable = false,referencedColumnName = "id")
     Customer Customer;
     
     

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer Customer) {
		this.Customer = Customer;
	}

	public int getStockId() {
		return StockId;
	}

	public void setStockId(int StockId) {
		this.StockId = StockId;
	}

	public String getStockdetails() {
		return Stockdetails;
	}

	public void setStockdetails(String Stockdetails) {
		this.Stockdetails = Stockdetails;
	}

	public String getStockStatus() {
		return status;
	}

	public void setStockStatus(String status) {
		this.status = status;
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
		return "Claim [StockId=" + StockId + ", Stockdetails=" +Stockdetails + ", Stockstatus="
				+ status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
      
}
//Child  entity