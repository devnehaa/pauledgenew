package com.springboot.pauledge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pauledge.dao.EmployeeRepo;
import com.springboot.pauledge.dto.Posts;
import com.springboot.pauledge.entity.BaseResponse;
import com.springboot.pauledge.entity.Employee;
import com.springboot.pauledge.entity.Holidays;
import com.springboot.pauledge.entity.PostDetails;
import com.springboot.pauledge.service.EmailSenderService;
import com.springboot.pauledge.service.EmployeeService;
import com.springboot.pauledge.service.HolidaysService;
import com.springboot.pauledge.service.OtpSaveandVerificationService;
import com.springboot.pauledge.service.PostDetailsService;



@RestController
public class Controller {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	OtpSaveandVerificationService otpSaveandVerificationService;
	
	@Autowired
	PostDetailsService postDetailsService;
	
	@Autowired
	EmployeeRepo employeeRepo;
    
    @Autowired
    private HolidaysService holidaysService;
    
	
	@GetMapping("/login")
	public String home()
	{
		return "This is Home Page.";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return this.employeeService.getEmployees();
	}
	
//	@GetMapping("/employees/{email}")
//	public Employee getEmployeeByEmailId(@PathVariable ("email") String email)
//	{
//		return this.employeeService.getEmployeeByEmailId(email);
//	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployeeByEmailId(@PathVariable ("empId") String empId)
	{
		return this.employeeService.getEmployeeByEmpId(empId);
	}

	@PostMapping(value = "/employees/getOtp")
	public BaseResponse getOtp(@RequestParam String toEmail, String empId)	
	{
		BaseResponse respNew = this.emailSenderService.getOtp(toEmail, empId);
		return respNew;
	}
	
	@PostMapping(value = "/employees/verifyOtp")
	public Map<String,String> verifyOtp(@RequestParam String toEmail, String empId, String otp)
	{	
		return this.otpSaveandVerificationService.verifyOtp(toEmail, empId, otp);
	}
	
	@GetMapping("/getMyModel")
	public BaseResponse getMyModel()
	{
	    return this.employeeService.getBase();
	}
	
	@GetMapping("/postDetails")
	public List<PostDetails> getPostDetails()
	{
		return this.postDetailsService.getPostDetails();
	}
	
	@GetMapping("/getContacts")
	public List<Object[]> getByDepartment()
	{
		return this.employeeService.getByDepartment();
	}
	
	@GetMapping("/contacts")
    public List<Map<String, Object>> getContactsByDepartment() {
        return this.employeeService.getContactsByDepartment();
    }
	
//	@GetMapping("/department-hierarchy")
//    public List<Map<String, Object>> getDepartmentHierarchy() {
//        return this.departmentService.getDepartmentEmployeeHierarchy();
//    }
	
	@GetMapping("/holidays")
	public List<Holidays> getHolidays()
	{
		return this.holidaysService.getHolidays();
	}
	
	@GetMapping("/allHolidays")
	public List<Map<String,Object>> getAllHolidays()
	{
		return this.holidaysService.getAllHolidays();
	}
	
	 @GetMapping("/posts")
	 public Posts getLayeredData()
	 {
	    return postDetailsService.getLayeredData();
	 }
}