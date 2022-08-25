package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		
		Optional<Employee> empOpt = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(empOpt.isPresent()) {
			employee = empOpt.get();
		}
		
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
	//	JPA Method
	//	employeeRepository.deleteById(id);
	// Our Method
		employeeRepository.deleteEmp(id);
	}

}