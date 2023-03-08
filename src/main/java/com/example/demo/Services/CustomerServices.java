package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CustomerEntity;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerServices {
	@Autowired
	CustomerRepository crepo;
	public String addDetails(CustomerEntity ee) {
		crepo.save(ee);
		return "Data added";
	}
	
	public String updateDetails(CustomerEntity ee) {
		crepo.saveAndFlush(ee);
		return "Data updated";
	}
	
	public String deleteDetails(int id) {
		crepo.deleteById(id);
		return "data Deleted";
	}
	public List<CustomerEntity> showDetails(){
		return crepo.findAll();
	}

}
