package com.steve.academysteveback.blog.service;


import com.steve.academysteveback.blog.dto.BlogDto;
import com.steve.academysteveback.blog.entity.BlogEntity;
import com.steve.academysteveback.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    ModelMapper modelMapper = new ModelMapper();

    /**
     * 강좌등록
     *
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


    public Page<BlogEntity> findByPageNo(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    // 각 리스트 표시 유/무
    public void blogListShowCheckService(Long seq) {
        Optional<BlogEntity> byId = blogRepository.findById(seq);
        BlogEntity blogEntity = byId.orElse(null);
        if (blogEntity.getDelYn().equals("N")) {
            int blogEntity1 = blogRepository.updateDelY(seq);
            System.out.println("blogEntity1 = " + blogEntity1);
        } else if (blogEntity.getDelYn().equals("Y")) {
            int blogEntity1 = blogRepository.updateDelN(seq);
            System.out.println("blogEntity1 = " + blogEntity1);
        } else System.out.println("BlogService.blogListShowCheckService ############");
    }

    // 전체 리스트 표시 유/무
    public void blogListsShowCheckService(Long seq, boolean status) {
        if (status) {
            int blogEntity1 = blogRepository.updateDelY(seq);
            System.out.println("blogEntity1 = " + blogEntity1);
        } else {
            int blogEntity1 = blogRepository.updateDelN(seq);
            System.out.println("blogEntity1 = " + blogEntity1);
        }
    }
}
