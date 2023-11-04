package com.demo.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.bo.CustomerBo;
import com.demo.bo.StockBo;
import com.demo.dao.CustomerRepository;
import com.demo.dao.UserRepository;
import com.demo.dto.CustomerDTO;
//import com.demo.dto.LibraryDTO;
import com.demo.dto.LoginRequest;
import com.demo.entity.Customer;
import com.demo.entity.User;
import com.demo.exception.CustomerException;
import com.demo.response.CustomerResponse;


@CrossOrigin
@RestController
public class Customerrest {
	@Autowired
	CustomerBo customer;
	
	@Autowired
	StockBo Stock;
	
	 @Autowired
     private UserRepository userRepository;

	
	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public CustomerDTO addcustomer (@RequestBody CustomerDTO msg) {
		System.out.println("Id:"+msg.getId());
		System.out.println("Name:"+msg.getName());
		System.out.println("email:"+msg.getEmail());
		System.out.println("gender:"+msg.getGender());
		System.out.println("Contact number:"+msg.getContactNumber());
		
		Customer cu=new Customer();
		//cu.setId(msg.getId());
		cu.setName(msg.getName());
		cu.setEmail(msg.getEmail());
		cu.setGender(msg.getGender());
		cu.setContactNumber(msg.getContactNumber());
		
		Customer cu1=customer.insertCustomer(cu);
		msg.setId(cu1.getId());
		msg.setCreatedAt(cu1.getCreatedAt());
		msg.setUpdatedAt(cu1.getUpdatedAt());
		return msg;
	}
	
	@RequestMapping(value="/findCustomer",method=RequestMethod.GET)
	public CustomerDTO findById(@RequestParam int id) {
		System.out.println("customer id"+id);
		Customer a= customer.findCustomer(id);
		CustomerDTO dto=new CustomerDTO();
		dto.setId(a.getId());
		dto.setName(a.getName());
		dto.setEmail(a.getEmail());
		dto.setContactNumber(a.getContactNumber());
		dto.setGender(a.getGender());
		dto.setCreatedAt(a.getCreatedAt());
		dto.setUpdatedAt(a.getUpdatedAt());
		return dto;
}
	
	@RequestMapping(value="/fetchAll" ,method=RequestMethod.GET)
	public List<CustomerDTO> findAll() {
		List<Customer> customerList=customer.findAllCustomer();
		CustomerDTO dto=new CustomerDTO();
		List<CustomerDTO> list=new ArrayList<>();
		for(Customer c:customerList)
		{
			dto=new CustomerDTO();
			dto.setCreatedAt(c.getCreatedAt());
			dto.setUpdatedAt(c.getUpdatedAt());
			dto.setName(c.getName());
			dto.setEmail(c.getEmail());
			dto.setContactNumber(c.getContactNumber());
			dto.setGender(c.getGender());
			dto.setId(c.getId());
			list.add(dto);
		}
		
		System.out.println("Customer Details Fetched Successfully...");
		
		return list;                        
	}
	
	@RequestMapping(value="/updateCustomer/{id}",method=RequestMethod.POST)
	public CustomerDTO updateOp(@PathVariable("id") Customer id,@RequestBody CustomerDTO msg) {
		System.out.println("name:" + msg.getName());
		System.out.println("email:" + msg.getEmail());
		System.out.println("ContactNumber:" + msg.getContactNumber());
		System.out.println("Gender:" + msg.getGender());
		Customer q=customer.updateCustomer(id);
		q.setName(msg.getName());
		q.setEmail(msg.getEmail());
		q.setContactNumber(msg.getContactNumber());
		q.setGender(msg.getGender());
		
		Customer q1=customer.updateCustomer(q);
		CustomerDTO  q2= new CustomerDTO();
		q2.setId(q1.getId());
		q2.setName(q1.getName());
		q2.setEmail(q1.getEmail());
		q2.setContactNumber(q1.getContactNumber());
		q2.setGender(q1.getGender());
		q2.setCreatedAt(q1.getCreatedAt());
		q2.setUpdatedAt(q1.getUpdatedAt());
		
		return q2;
	}
		@RequestMapping(value ="/findAllOrderByNameDescending", method = RequestMethod.GET)
		@CrossOrigin(origins = "https://localhost:3000")
		public List<CustomerDTO> findAllOrderByNameDescending() {
		    List<Customer> descending = customer.findAllOrderByNameDescending();
		    List<CustomerDTO> descendingDTOs = new ArrayList<>();

		    // Convert Customer entities to CustomerDTOs
		    for (Customer c : descending) {
		        CustomerDTO dto = new CustomerDTO();
		        dto.setId(c.getId());
		        dto.setName(c.getName());
		        dto.setEmail(c.getEmail());
		        dto.setContactNumber(c.getContactNumber());
		        dto.setGender(c.getGender());
		        dto.setCreatedAt(c.getCreatedAt());
		        dto.setUpdatedAt(c.getUpdatedAt());
		        descendingDTOs.add(dto);
		    }

		    return descendingDTOs;
		}
		
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
	        Map<String, Object> response = new HashMap<>();

	        User user = userRepository.findByUsername(loginRequest.getUsername());

	        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
	            response.put("success", true);
	            response.put("message", "Login successful");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("success", false);
	            response.put("message", "Invalid Customer");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
		}

		  @RestControllerAdvice public class GlobalExceptionHandler {
		  
		  @ExceptionHandler(CustomerException.class) public ResponseEntity<String>
		  handleCustomerException(CustomerException ex) { return
		  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()); 
		  }
		
		  }
		 
/*
		@RequestMapping(value = "/greaterThanId", method = RequestMethod.GET)
		public ResponseEntity<List<Customer>> findCustomerById(@RequestParam int id) {
		    try {
		        List<Customer> customers = customer.filterById(id);
		        return ResponseEntity.ok(customers);
		    } catch (CustomerException ex) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		    }
		}

	

	//FindAllOrderByNameDesc
	/*@RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
	public List<Customer> findAllOrderByNameDescending() 
	{
	    List<Customer> list = customer.findAllOrderByNameDescending();
	    return list;
	    }*/
	
/*
 * //Inner Join
 * 
 * @RequestMapping(value = "/applicantsWithLoans", method = RequestMethod.GET)
 * public List<Customer> findApplicantWithLoans() { List<Customer> list =
 * customer.findCustomerWithPersLeft(); return list; }}
 */
/*
 * //Left Outer Join
 * 
 * @RequestMapping(value = "/applicantsWithLoansLeft", method =
 * RequestMethod.GET) public List<Customer> findApplicantWithLoansLeft() {
 * List<Customer> list = customer.findCustomerWithPersLeft(); return list; }
 */
	
	  //Customized join
	/*  
	  @RequestMapping(value = "/applicantsWithLoansCustomized", method =
	  RequestMethod.GET) public List <CustomerCustomized>
	  findApplicantWithLoansCustomized() { List <CustomerCustomized> list =
	  customer.findCustomerWithPersCust(); return list; }*/
	  
	
}


