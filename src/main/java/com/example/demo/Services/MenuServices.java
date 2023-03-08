package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MenuEntity;
import com.example.demo.Repository.MenuRepository;

@Service
public class MenuServices {

	@Autowired
	MenuRepository Mrepo;
	public String addDetails(MenuEntity ee) {
		Mrepo.save(ee);
		return "Data added";
	}
	
	public String updateDetails(MenuEntity ee) {
		Mrepo.saveAndFlush(ee);
		return "Data updated";
	}
	
	public String deleteDetails(int id) {
		Mrepo.deleteById(id);
		return "data Deleted";
	}
	public List<MenuEntity> AscsortByField(String field){
		return Mrepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<MenuEntity> DescsortByField(String field){
		return Mrepo.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	public Optional<MenuEntity> getById(int id) {
		return Mrepo.findById(id);
	}
	public List<MenuEntity> showDetails(){
		return Mrepo.findAll();
	}
	
	public List<MenuEntity> getWithPagination(int offset,int pageSize){
		Page<MenuEntity> page = Mrepo.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
	
	public String deleteall() {
		Mrepo.deleteAll();
		return "All data deleted";
	}
}
