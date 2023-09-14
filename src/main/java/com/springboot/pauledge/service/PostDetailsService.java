package com.springboot.pauledge.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pauledge.dao.PostDetailsRepo;
import com.springboot.pauledge.dto.PostType;
import com.springboot.pauledge.dto.Posts;
import com.springboot.pauledge.dto.Categories;
import com.springboot.pauledge.entity.PostDetails;

@Service
public class PostDetailsService {
	
	@Autowired PostDetailsRepo postDetailsRepo;
	
 	public List<PostDetails> getPostDetails()
 	{
 		return postDetailsRepo.findAll();
 	}
 	
 	public Posts getLayeredData() {
 		
        List<PostDetails> postDetailsList = postDetailsRepo.findAll();

        List<PostType> typeDTOList = new ArrayList<>();

        // Creating the "All" type entry
        PostType allTypeDTO = new PostType();
        allTypeDTO.setType("All");
        allTypeDTO.setNew_post_count(postDetailsList.size());

        Categories emptyCategory = new Categories();
        emptyCategory.setSub_type("");
        List<Categories> emptyCategoryList = new ArrayList<>();
        emptyCategoryList.add(emptyCategory);
        allTypeDTO.setCategories(emptyCategoryList);

        typeDTOList.add(allTypeDTO);

        Map<String, List<PostDetails>> groupedByType = postDetailsList.stream()
                .collect(Collectors.groupingBy(PostDetails::getType));

        for (Map.Entry<String, List<PostDetails>> entry : groupedByType.entrySet()) {
            PostType typeDTO = new PostType();
            typeDTO.setType(entry.getKey());
            typeDTO.setNew_post_count(entry.getValue().size());

            List<Categories> categories = entry.getValue().stream()
                    .map(dto -> {
                        Categories categoryDTO = new Categories();
                        categoryDTO.setSub_type(dto.getSub_type());
                        return categoryDTO;
                    })
                    .distinct()
                    .collect(Collectors.toList());

            typeDTO.setCategories(categories);
            typeDTOList.add(typeDTO);
        }

        List<PostDetails> postDetailsDTOList = postDetailsList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new Posts(typeDTOList, postDetailsDTOList);
    }

    private PostDetails convertToDTO(PostDetails postDetails) {
        PostDetails dto = new PostDetails();
        dto.setType(postDetails.getType());
        dto.setSub_type(postDetails.getSub_type());
        dto.setTitle(postDetails.getTitle());
        dto.setImd_url(postDetails.getImd_url());
        dto.setIsLike(postDetails.getIsLike());
        dto.setLike_count(postDetails.getLike_count());
        dto.setDesc(postDetails.getDesc());
        return dto;
    }

}