package com.springboot.pauledge.dto;

import java.util.List;

public class PostType {

	
	public String type;
	public int new_post_count;
	public List<Categories> categories;
	
	
	public PostType() {
		super();
	}
	
	public PostType(String type, int new_post_count, List<Categories> categories) {
		super();
		this.type = type;
		this.new_post_count = new_post_count;
		this.categories = categories;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNew_post_count() {
		return new_post_count;
	}
	public void setNew_post_count(int new_post_count) {
		this.new_post_count = new_post_count;
	}
	public List<Categories> getCategories() {
		return categories;
	}
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "PostType [type=" + type + ", new_post_count=" + new_post_count + ", categories=" + categories + "]";
	}
	
}
