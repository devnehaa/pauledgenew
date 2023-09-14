package com.springboot.pauledge.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.pauledge.PauledgeApplication;
import com.springboot.pauledge.entity.BaseResponse;



@Configuration
@Service
public class EmailSenderService {
	
		@Autowired
		OtpSaveandVerificationService otpSaveandVerificationService;
		
		
	 	public BaseResponse getOtp(@RequestParam String toEmail, String empId)
		{	            
				JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//			    javaMailSender.setHost("smtp.outlook.com");
				javaMailSender.setHost("smtp.gmail.com");
			    javaMailSender.setPort(587);		    
			    
//			    javaMailSender.setUsername("neha.singla@paulmerchants.net");
//			    javaMailSender.setPassword("admin@#852%");
//			    javaMailSender.setPassword("534240f344988f69d43f0d02679091a1");
			    javaMailSender.setUsername("nehasingla496@gmail.com");
			    javaMailSender.setPassword("zjtfoxpfjsduqaap");
		    
			    Properties props = javaMailSender.getJavaMailProperties();
//	 			Properties props = new Properties();
				
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
				props.put("mail.smtp.port", "587"); //TLS Port
				props.put("mail.smtp.username", "nehasingla496@gmail.com");
				props.put("mail.smtp.password", "zjtfoxpfjsduqaap");
				props.put("mail.smtp.starttls.required", "true"); //enable STARTTLS
				props.put("mail.smtp.auth", "true"); //enable authentication
				props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//				props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			    props.put("mail.transport.protocol", "smtp");
			    props.put("mail.debug", "true");
			    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			    props.put("mail.smtp.ssl.enable", "false"); //setting true value giving exception
			    props.put("mail.smtp.connectiontimeout", 10000);
			    props.put("mail.smtp.timeout", 10000);
			    props.put("mail.smtp.writetimeout", 10000);
			    
//			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//			    props.put("mail.smtp.socketFactory.fallback", "false");
			    
			   			    
				System.out.println("Mail Step1");	
				System.out.println(toEmail);
				System.out.println(empId);
				
				try {
					String clearOtp = this.otpSaveandVerificationService.clearOTP(toEmail, empId);
					
					BaseResponse resp = null;
					String msg="";
					
					if (clearOtp.isEmpty())
					{
						String otp = PauledgeApplication.generateOTP();
					
			        	// MimeMessage message = new MimeMessage();
			            SimpleMailMessage message = new SimpleMailMessage();
			            //mailMessage.setFrom("neha.singla@paulmerchants.net");
			            message.setFrom("nehasingla496@gmail.com");
			            message.setTo(toEmail);
			            message.setSubject("OTP FOR PAULEDGE APPLICATION- " + empId);
			            message.setText("Hey! I am your secret code.... " + otp);
			           
			            // Sending the mail
			            javaMailSender.send(message);
			            msg = "OTP has been sent successfully on your Email Id";
			            this.otpSaveandVerificationService.saveOtp(toEmail, empId, otp);
			            resp = new BaseResponse("200", msg);
			        }
					else 
					{
			        	msg = "Invalid Email Id & Employee Id";
			        	resp = new BaseResponse("400", msg);
			        }
			        return resp;
				}
				catch (Exception e){
					e.printStackTrace();
			        return new BaseResponse("500", "An error occurred while sending the email.");
			    }
		}
}
