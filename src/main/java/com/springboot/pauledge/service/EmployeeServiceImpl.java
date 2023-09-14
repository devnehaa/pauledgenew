package com.springboot.pauledge.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pauledge.dao.EmployeeRepo;
import com.springboot.pauledge.entity.BaseResponse;
import com.springboot.pauledge.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	 	@Autowired EmployeeRepo employeeRepo;
	 	
	 	
	 	@Override	
	 	public List<Employee> getEmployees()
	 	{
	 		return employeeRepo.findAll();
	 	}
	 	
//
//		public Employee getEmployeeByEmailId(String email) {
//			
//			Employee e = null;
//			
//			for(Employee emp : employeeRepo.findAll()) 
//			{
//				if(emp.getEmail_id().equals(email)) 
//				{
//							e = emp;
//							break;
//				}
//			}
//			
//			return e;
//		}

		@Override
		public Employee getEmployeeByEmpId(String empId) {
			return employeeRepo.findEmployeeById(empId);
		}

		@Override
		public BaseResponse getBase() {
			return new BaseResponse("","");
		}

		@Override
		public List<Object[]> getByDepartment() {
			return employeeRepo.findByDepartment();
		}

		@Override
		public List<Map<String, Object>> getContactsByDepartment() {
			List<Object[]> rawData = employeeRepo.findContactsByDepartment();
		    Map<String, List<Map<String, String>>> departmentEmployeeMap = new LinkedHashMap<>();

		    for (Object[] row : rawData) {
		        String departmentName = ((String) row[0]).trim();
		        String empName = (String) row[1];
		        String contactNum = (String) row[2];

		        List<Map<String, String>> employees = departmentEmployeeMap.getOrDefault(departmentName, new ArrayList<>());

		        Map<String, String> employee = new LinkedHashMap<>(); //creating object of LinkedHashMap<> for an employee detail
		        employee.put("emp_name", empName);
		        employee.put("contact_num", contactNum);
		        employees.add(employee);

		        departmentEmployeeMap.put(departmentName, employees);
		    }

		    List<Map<String, Object>> response = new ArrayList<>();

		    for (Map.Entry<String, List<Map<String, String>>> entry : departmentEmployeeMap.entrySet()) //entrySet contains (departmentName, employees)
		    {
		        Map<String, Object> departmentMap = new LinkedHashMap<>();
		        departmentMap.put("department_name", entry.getKey());
		        departmentMap.put("employee", entry.getValue());
		        response.add(departmentMap);
		    }

		    return response;
		}
}
