package com.springboot.pauledge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pauledge.entity.Employee;
	

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	@Query(value = "SELECT * FROM pmfpl_employees_data WHERE emp_id = :empId", nativeQuery = true)
    Employee findEmployeeById(String empId);
	
	@Query(nativeQuery = true,
				value = "SELECT e.department AS department_name, e.name AS emp_name, e.phone_no AS contact_num " +
	                   "FROM pmfpl_employees_data e ORDER BY e.department")
	List<Object[]> findContactsByDepartment();
	
	@Query(nativeQuery = true,
			value = "SELECT e.department, e.name, e.phone_no FROM pmfpl_employees_data e")
	List<Object[]> findByDepartment();
}