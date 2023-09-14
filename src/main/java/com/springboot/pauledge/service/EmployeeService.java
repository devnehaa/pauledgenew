package com.springboot.pauledge.service;

import java.util.List;
import java.util.Map;

import com.springboot.pauledge.entity.BaseResponse;
import com.springboot.pauledge.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	//public Employee getEmployeeByEmailId(String email);
	
	public Employee getEmployeeByEmpId(String empId);
	
	public BaseResponse getBase();
	
	public List<Object[]> getByDepartment();
	
	public List<Map<String, Object>> getContactsByDepartment();
		
}
