package com.springboot.pauledge.dto;


public class Categories {
	
	public String sub_type;

	public Categories() {
		super();
	}
	
	public Categories(String sub_type) {
		super();
		this.sub_type = sub_type;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	@Override
	public String toString() {
		return "Categories [sub_type=" + sub_type + "]";
	}
	
}
