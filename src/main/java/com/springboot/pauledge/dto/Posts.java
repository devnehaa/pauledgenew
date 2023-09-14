package com.springboot.pauledge.dto;

import java.util.List;

import com.springboot.pauledge.entity.PostDetails;

public class Posts {

	public List <PostType> postType;
	
	public List <PostDetails> postDetails;

	public Posts(List<PostType> postType, List<PostDetails> postDetails) {
		super();
		this.postType = postType;
		this.postDetails = postDetails;
	}

	public List<PostType> getPostType() {
		return postType;
	}

	public void setPostType(List<PostType> postType) {
		this.postType = postType;
	}

	public List<PostDetails> getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(List<PostDetails> postDetails) {
		this.postDetails = postDetails;
	}
	
}
