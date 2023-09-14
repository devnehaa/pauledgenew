package com.springboot.pauledge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pauledge.entity.PostDetails;

public interface PostDetailsRepo extends JpaRepository<PostDetails, String> {

}
