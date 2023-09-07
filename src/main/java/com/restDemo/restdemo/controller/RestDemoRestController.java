package com.restDemo.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restDemo.restdemo.entity.Employee;
import com.restDemo.restdemo.repository.RestDemoRepository;

@RestController
@RequestMapping("/api")
public class RestDemoRestController {
	@Autowired
	private RestDemoRepository restDemoRepo;
	
	@PostMapping("/post")
	public Employee saveData(@RequestBody Employee employee) {
		return restDemoRepo.save(employee);
	}
	
	@GetMapping("/get")
	public List<Employee> readData(){
		return restDemoRepo.findAll();
	}
	@DeleteMapping("/del/{id}")
	public String deleteData(@PathVariable("id")long id) {
		restDemoRepo.deleteById(id);
		return "successfully deleted";
	}
	@PutMapping("/put/{id}")
	public Employee updateData(@PathVariable("id") long id,@RequestBody Employee employee) {
		Employee e2 = restDemoRepo.findById(id).get();
		e2.setId(employee.getId());
		e2.setName(employee.getName());
		e2.setCity(employee.getCity());
		return restDemoRepo.save(e2);
		
	}

}
