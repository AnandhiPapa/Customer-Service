package com.example.demo;

//import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.dao.CustomerCustomized;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;
//import com.demo.dao.CustomerCustomized;
//import com.demo.dao.CustomerCustomized.CustomerEntityCustomized;
//import com.demo.entity.*;
//import com.demo.service.*;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.demo")
@EntityScan(basePackages = {"com.demo.entity"})
@EnableJpaRepositories("com.demo.dao")

     
public class Crud1Application {

	public static void main(String[] args) { 
		
		ApplicationContext ctx = SpringApplication.run(Crud1Application.class, args);
		
		//task 1 insert customer
		/*CustomerService service = ctx.getBean(CustomerService.class);
		Customer customerobj = new Customer();
		customerobj.setName("Samii");
		customerobj.setEmail("Samii@gamil.com");
		customerobj.setGender("Male");
		customerobj.setContactNumber((int) 851306810);*/
		
	    //service.insertServiceCustomer(customerobj);
		
		//task 2 insert Stock
		/*   StockService serviceStock = ctx.getBean(StockService.class);
		Stock Stockrobj = new Stock();
		Stockrobj.setStockStatus("InProgress");
		Stockrobj.setStockdetails("Important Stock");
		 
		Customer custom = new Customer();
		custom.setId(1);
		Stockrobj.setCustomer(custom);
		serviceStock.insertServiceStock(Stockrobj);
		
		//task 3 insert Stock
		Stock c1 = new Stock();
		c1.setStockStatus("Rejected");
		c1.setStockdetails("Not related");
		
		Stock c2 = new Stock();
		c2.setStockStatus("InProgess");
		c2.setStockdetails("theft");
		
		//insert Customer
		Customer cu1 = new Customer();
		customerobj.setId(1);
		cu1.setName("Anandhi");
		cu1.setEmail("Kesav@gmail.com");
		cu1.setGender("Female");
		cu1.setContactNumber((int) 851306810);
		
		
		//Associating Stock to Customer
		c1.setCustomer(cu1);
		c2.setCustomer(cu1);
		
		//Associating Customer with Stock
		List<Stock> cu2 = new ArrayList<Stock>();
		cu2.add(c1);
		cu2.add(c2);
		cu1.setStock(cu2);
		
		System.out.println("Adding Customer.......");
		CustomerService service3 = ctx.getBean(CustomerService.class);
		service3.insertServiceCustomer(cu1);

		
		//fetch
		System.out.println(service.findServiceCustomer(1));*/
		
		
		//fetchAll
		//System.out.println(service.findAllServiceCustomer());
				
	    CustomerService tsc  = ctx.getBean(CustomerService.class);
		/*Stock Stock = new Stock();
		Stock.setStockdetails("Stock Important");
		Stock.setStockStatus("At Progress");
		
		Customer cu1 = new Customer();
		cu1.setId(2);
		Stock.setCustomer(cu1);
		
		Customer cu2 = new Customer();
		cu2.setContactNumber((int) 967740810);
		cu2.setName("Chellam");
		cu2.setEmail("Chellam@gmail.com");*/
	
		
		//tsc.Stockmanagement(cu2,Stock);
		
		//@query1
		//List<Customer> list=tsc.filterById(8);
		//System.out.println("Customer based on id"+list);
		
		//@query2
		//List<Customer> list1=tsc.filterByName("i");
		//System.out.println("Customer  name with i"+list1);
		
		//named query
	   //System.out.println("details Order by name desc: "+tsc.findAllOrderByNameDescending());
		
		//update
		//customerobj.setId(2);
		//customerobj.setEmail("tanjiro@gmail.com");
		//service.updateServiceCustomer(customerobj);		
		
	//Inner Join  
	//List<Customer> list3 = tsc.findCustomerWithPers();
	//System.out.println("Credentials with Personal_details Inner Join: " + list3);
	
	//Left Join 
	//List<Customer> list4 = tsc.findCustomerWithPersLeft();
	//System.out.println("Credentials with Personal_details Left Join: " + list4);
	
	//customized data by Join 
	//List<CustomerCustomized> list5 = tsc.findCustomerWithPersCust();
	//for(CustomerCustomized cust: list5) {
		//System.out.println("Credentials with Personal_details customized Join: " + cust.getname()+"-"+cust.getemail());
	}
	}
//main
