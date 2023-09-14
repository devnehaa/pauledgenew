package com.springboot.pauledge.service;

import java.util.Map;
import java.util.LinkedHashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pauledge.dao.EmployeeRepo;
import com.springboot.pauledge.entity.Employee;

@Service
public class OtpSaveandVerificationService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	public void saveOtp(String toEmail, String empId, String otp) {
		Employee e = null;
		for(Employee emp : employeeRepo.findAll())
		{
			if(emp.getEmail_id().equalsIgnoreCase(toEmail) ) 
			{
				if(emp.getEmp_id().equalsIgnoreCase(empId)) {
					emp.setOtp(otp);
					e = emp;
					System.out.println("YOUR OTP IS: " + e.getOtp());
					employeeRepo.save(e);
					System.out.println("OTP successfully saved in DB");
					break;
				}
			}
		}
	}
	

	public String clearOTP(String toEmail, String empId) {
		Employee e = null;
		String clearOtp = ""; 
		for(Employee emp : employeeRepo.findAll()) 
		{
			if(emp.getEmail_id().equalsIgnoreCase(toEmail)) 
			{
				if(emp.getEmp_id().equalsIgnoreCase(empId))
				{
					emp.setOtp(null);
					e = emp;
					System.out.println("CLEAR OTP " + e.getOtp());
					employeeRepo.save(e);
					clearOtp = "";
					break;
				}
				else
				{
					clearOtp = "Invalid Employee Id";
				}
				break;
			}
			else
			{
				clearOtp = "Email Id is not found in DB";
			}
		}
		System.out.println(clearOtp);
		return clearOtp;
	}
	
	
	public Map<String, String> verifyOtp(String toEmail, String empId, String otp) {
		
		String verifiedOtp = "";
		
		Map<String, String> resp1 = new LinkedHashMap<>();
		
		System.out.println("___CHECK___" + otp);

		for(Employee emp : employeeRepo.findAll()) 
		{	
			if(emp.getEmail_id().equals(toEmail) ) 
			{
				if(emp.getEmp_id().equalsIgnoreCase(empId)) 
				{	
					System.out.println("___CHECK___" + emp.getEmp_id());
		
					if(emp.getOtp().equals(otp)) {
						System.out.println("___CHECK___"+ emp.getOtp());
						verifiedOtp = "Otp Verified Successfully";
						resp1.put("Status", "200");
						resp1.put("Message", verifiedOtp);
						break;
					}
					else {
						verifiedOtp = "Invalid OTP";
						resp1.put("Status", "400");
						resp1.put("Message", verifiedOtp);
					}
					break;
				}
				else {
					verifiedOtp = "Invalid Employee Id";
					resp1.put("Status", "400");
					resp1.put("Message", verifiedOtp);
				}
				break;	
			}
			else {
				verifiedOtp = "Invalid Email Id";
				resp1.put("Status", "400");
				resp1.put("Message", verifiedOtp);
			}	
		}
		System.out.println(verifiedOtp);
		return resp1;	
	}

}
