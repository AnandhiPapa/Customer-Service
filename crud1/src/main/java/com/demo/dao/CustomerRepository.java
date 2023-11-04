package com.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.entity.Customer;
import com.demo.exception.CustomerException;
import com.demo.response.CustomerResponse;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	//Fetching all columns
	@Query(value="select c from Customer c where c.id> :id")
	List<Customer> filterById(@Param("id") int id);
	//List<Customer> findAllByDesc();
	
	/*@Query("select c from Customer c where c.name Like%:name%")
	List<Customer>filterByName(@Param("name")String name);*/
	
	//Fetching only few columns
	/*@Query("select c.street as street from Cred1Entity c where c.name=:name")
	List<CustomerCustomized>filterByNameCustomized(@Param("name")String name);*/

	//NamedQuery
	List<Customer> findAllOrderByNameDescending();
	
		
	//Inner Join
	/*
	 * @Query("select c from Customer c JOIN c.cred2") List<Customer>
	 * findCustomerWithPers();
	 * 
	 * //Left Outer Join
	 * 
	 * @Query("select c from Customer c left JOIN c.cred2") List<Customer>
	 * findCustomerWithPersLeft();
	 * 
	 * //customized data by join
	 * 
	 * @Query("select c.name as name,c.street as street from Customer c JOIN c.cred2"
	 * ) List<CustomerCustomized> findCustomerWithPersCust();
	 */
	//exception
	@RestControllerAdvice
	public class GlobalExceptionHandler {
	    @ExceptionHandler(CustomerException.class)
	    public ResponseEntity<String> handleCredException(CustomerException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	}}

	
