package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CustomerEntity;
import com.example.demo.Model.MenuEntity;
import com.example.demo.Services.CustomerServices;
import com.example.demo.Services.MenuServices;

@RestController
@CrossOrigin
public class Controller {
	
	@Autowired
	MenuServices Mservice;
	
	@Autowired
	CustomerServices Cservices;

	//CREATE 
	@PostMapping("/addDetails")
	public String add(@RequestBody MenuEntity ee) {
		return Mservice.addDetails(ee);
	}
	@PostMapping("/addCustomer")
	public String addcustomer(@RequestBody CustomerEntity ee) {
		return Cservices.addDetails(ee);
	}
	
	//READ
	@GetMapping("/showDetails")
	public List <MenuEntity> show() {
		return Mservice.showDetails();
	}
	@GetMapping("/showCustomer")
	public List<CustomerEntity> showcustomer() {
		return Cservices.showDetails();
	}
	
	
	//READ By ID
	@GetMapping("/showDetails/{id}")
	public Optional<MenuEntity> getById(@PathVariable int id) {
		return Mservice.getById(id);
	}
	
	//READ By Ascending sorted order
	@GetMapping("/AscsortedDetails/{field}")
	public List <MenuEntity> sortasc(@PathVariable String field){
		return Mservice.AscsortByField(field);
	}
		
	//READ by Descending sorted order
	@GetMapping("/DescsortedDetails/{field}")
	public List <MenuEntity> sortdesc(@PathVariable String field){
		return Mservice.DescsortByField(field);
	}
	
	//READ with Pagination
	@GetMapping("/pagination")
	public List <MenuEntity> pagination(@RequestParam int offset,@RequestParam int pagesize){
		return Mservice.getWithPagination(offset,pagesize);
	}
	
	//UPDATE
	@PutMapping("/updateDetails")
	public String update(@RequestBody MenuEntity ee) {
		return Mservice.updateDetails(ee);
	}
	@PutMapping("/updateCustomer")
	public String updatecustomer(@RequestBody CustomerEntity ee) {
		return Cservices.updateDetails(ee);
	}
	
	//DELETE by ID
	@DeleteMapping("/deleteDetails/{eid}")
	public String delete(@PathVariable("eid") int id) {
		return Mservice.deleteDetails(id);
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		return Cservices.deleteDetails(id);
	}
	
	//DELETE all the details
	@DeleteMapping("/deleteAll")
	public String deleteall() {
		return Mservice.deleteall();
	}
	
	

}
