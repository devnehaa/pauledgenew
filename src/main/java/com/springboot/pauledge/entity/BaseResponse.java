package com.springboot.pauledge.entity;

public class BaseResponse {
	
	public String status;
	public String message;
	
	public BaseResponse(String status,String message) {
		this.status = status;
		this.message = message;
	}

}
