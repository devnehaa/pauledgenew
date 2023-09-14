package com.springboot.pauledge.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pauledge.dao.EmployeeRepo;
import com.springboot.pauledge.entity.Employee;

@Service
public class DepartmentService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	

    public List<Map<String, Object>> getDepartmentEmployeeHierarchy() {
        List<Employee> employees = employeeRepo.findAll();

        Map<String, List<Map<String, String>>> departmentEmployeeMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(this::mapEmployeeToMap, Collectors.toList())
                ));

        return departmentEmployeeMap.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> departmentMap = Map.of(
                            "department_name", entry.getKey(),
                            "employee", entry.getValue()
                    );
                    return departmentMap;
                })
                .collect(Collectors.toList());
    }

    private Map<String, String> mapEmployeeToMap(Employee employee) {
        return Map.of(
                "emp_name", employee.getName(),
                "contact_num", employee.getPhone_no()
        );
    }
		    
		    
//		    List<Object[]> rawData = employeeRepo.findContactsByDepartment();
//
//		    Map<String, List<Map<String, String>>> departmentEmployeeMap = rawData.stream()
//		        .map(row -> new Object[] {
//		            ((String) row[0]).trim(),
//		            (String) row[1],
//		            (String) row[2]
//		        })
//		        .collect(Collectors.groupingBy(
//		            row -> (String) row[0],
//		            Collectors.mapping(row -> {
//		                Map<String, String> employee = new LinkedHashMap<>();
//		                employee.put("emp_name", (String) row[1]);
//		                employee.put("contact_num", (String) row[2]);
//		                return employee;
//		            }, Collectors.toList())
//		        ));
//
//		    return departmentEmployeeMap.entrySet().stream()
//		        .map(entry -> {
//		            Map<String, Object> departmentMap = new LinkedHashMap<>();
//		            departmentMap.put("department_name", entry.getKey());
//		            departmentMap.put("employee", entry.getValue());
//		            return departmentMap;
//		        })
//		        .collect(Collectors.toList());
		
		    
		    
//        List<Object[]> rawData = employeeRepo.findContactsByDepartment(); //calling query method
//        List<Map<String, Object>> response = new ArrayList<>(); //creating object of ArrayList to return response in required format
//
//        for (Object[] row : rawData) {
//            Map<String, Object> departmentMap = new LinkedHashMap<>(); //creating object of LinkedHashMap for departments name
//            departmentMap.put("department_name", row[0]);
//            List<Map<String, String>> employees = new ArrayList<>(); //creating object of ArrayList for Employees List
        
//		    Map<String, String> employee = new LinkedHashMap<>(); //creating object of LinkedHashMap for single Employee
//            employee.put("emp_name", (String) row[1]);	
//            employee.put("contact_num", (String) row[2]);
//            employees.add(employee);
		    
//            departmentMap.put("employee", employees);
//            response.add(departmentMap);
//        }

//        return response;
//    }

}
