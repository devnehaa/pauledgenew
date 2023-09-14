package com.springboot.pauledge.entity;

import java.sql.Date;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="pmfpl_employees_data")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String emp_id;
	private String name;
	private String phone_no;
	private String email_id;
	private Date dob;
	private Date doj;
	private String designation;
	private String grade;
	private String department;
	private String location;
	private String location_state;
	private String image;
    private String otp;
    
	
//    @Column(name = "otp_requested_time")
//    private Date otpRequestedTime;
//    
//    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
//     
//	public Date getOtpRequestedTime() {
//		return otpRequestedTime;
//	}
//
//	public void setOtpRequestedTime(Date otpRequestedTime) {
//		this.otpRequestedTime = otpRequestedTime;
//	}
//
//
//	public boolean isOTPRequired() {
//        if (this.getOneTimePassword() == null) {
//            return false;
//        }
//         
//        long currentTimeInMillis = System.currentTimeMillis();
//        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
//         
//        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
//            // OTP expires
//            return false;
//        }
//         
//        return true;
//    }
     
    public Employee() {
		super();
	}

    
	public Employee(String emp_id, String name, String phone_no, String email_id, Date dob, Date doj, String designation,
		String grade, String department, String location, String location_state, String image, String otp) {
	super();
	this.emp_id = emp_id;
	this.name = name;
	this.phone_no = phone_no;
	this.email_id = email_id;
	this.dob = dob;
	this.doj = doj;
	this.designation = designation;
	this.grade = grade;
	this.department = department;
	this.location = location;
	this.location_state = location_state;
	this.image = image;
	this.otp = otp;
}


	public String getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getLocation_state() {
		return location_state;
	}


	public void setLocation_state(String location_state) {
		this.location_state = location_state;
	}
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", phone_no=" + phone_no + ", email_id=" + email_id
				+ ", dob=" + dob + ", doj=" + doj + ", designation=" + designation + ", grade=" + grade
				+ ", department=" + department + ", location=" + location + ", location_state=" + location_state
				+ ", image=" + image + ", otp=" + otp + "]";
	}
	
}
