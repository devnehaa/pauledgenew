package com.springboot.pauledge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="post_details")
public class PostDetails {
		
	@Id
	public String type;
	public String sub_type;
	public String title;
	public String imd_url;
	public boolean isLike;
	public int like_count;
	public String desc;
	
	
	public PostDetails() {
		super();
	}
	
	public PostDetails(String type, String sub_type, String title, String imd_url, boolean isLike, int like_count,
			String desc) {
		super();
		this.type = type;
		this.sub_type = sub_type;
		this.title = title;
		this.imd_url = imd_url;
		this.isLike = isLike;
		this.like_count = like_count;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSub_type() {
		return sub_type;
	}
	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImd_url() {
		return imd_url;
	}
	public void setImd_url(String imd_url) {
		this.imd_url = imd_url;
	}
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "PostDetail [type=" + type + ", sub_type=" + sub_type + ", title=" + title + ", imd_url="
				+ imd_url + ", isLike=" + isLike + ", like_count=" + like_count + ", desc=" + desc + "]";
	}
}