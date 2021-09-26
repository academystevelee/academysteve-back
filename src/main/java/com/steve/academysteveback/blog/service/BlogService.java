package com.steve.academysteveback.blog.service;


import com.steve.academysteveback.blog.dto.BlogDto;
import com.steve.academysteveback.blog.entity.BlogEntity;
import com.steve.academysteveback.blog.repository.BlogRepository;
import com.steve.academysteveback.util.commoncode.CommonCodeService;
import com.steve.academysteveback.util.commoncode.CommonDto;
import com.steve.academysteveback.util.commoncode.CommonEntity;
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

  @Autowired
  CommonCodeService commonCodeService;


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
  public BlogEntity findByBlogNo(Long blogNo) {


    BlogEntity blogEntity = blogRepository.findBySeq(blogNo);

    blogEntity.setHit(blogEntity.getHit() + 1);
    blogRepository.save(blogEntity);

    return blogEntity;
  }


  public Page<BlogEntity> findByPageNo(Pageable pageable){


    Page<BlogEntity> pbloglist = blogRepository.findAll(pageable);

    for(int n = 0 ; n < pbloglist.getContent().size() ; n ++) {

      CommonDto commonDto =  new CommonDto();
      commonDto.setCode1("cate");
      commonDto.setCode2(pbloglist.getContent().get(n).getCate());

      CommonEntity commonEntity = commonCodeService.findCodeName(commonDto);
      pbloglist.getContent().get(n).setCate(commonEntity.getCodename());

    }

    return pbloglist;
  }



}
