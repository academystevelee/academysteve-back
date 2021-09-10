package com.steve.academysteveback.blog.service;


import com.steve.academysteveback.blog.dto.BlogDto;
import com.steve.academysteveback.blog.entity.BlogEntity;
import com.steve.academysteveback.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

  @Autowired
  BlogRepository blogRepository;


  ModelMapper modelMapper = new ModelMapper();


  /**
   * 강좌등록
   * @param blogDto
   */
  public void register(BlogDto blogDto) {
    BlogEntity blogEntity = new BlogEntity();
    blogEntity = modelMapper.map(blogDto, BlogEntity.class);

    blogRepository.save(blogEntity);
  }

  /**
   * 강좌조회
   */
  public Optional<BlogEntity> findByBlogNo(Long blogNo) {


    Optional<BlogEntity> blogEntity = blogRepository.findById(blogNo);

    return blogEntity;
  }


  public Page<BlogEntity> findByPageNo(Pageable pageable){

    return blogRepository.findAll(pageable);
  }



}
