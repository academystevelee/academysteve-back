package com.steve.academysteveback.blog;

import com.steve.academysteveback.blog.dto.BlogDto;
import com.steve.academysteveback.blog.entity.BlogEntity;
import com.steve.academysteveback.blog.service.BlogService;
import com.steve.academysteveback.lecture.dto.EnrollPageDto;
import com.steve.academysteveback.lecture.entity.ClassDtEntity;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/blog")
@RestController
public class BlogController {



    @Autowired
    BlogService blogService;



    @PostMapping("/register")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public void lecture(@RequestBody BlogDto blogDto) throws Exception {
        System.out.println("blogDto ok : " + blogDto) ;
        blogDto.setHit(new Long(0));

        blogService.register(blogDto);


    }

    @GetMapping("/blogview/{blogno}")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public BlogEntity blogviewfindByBlogNo(@PathVariable Long blogno) throws Exception {
        System.out.println("blogno ok : " + blogno) ;
        BlogEntity blogEntity = blogService.findByBlogNo(blogno);


        return blogEntity;

    }

    @GetMapping("/bloglist")
    @ApiOperation(value = "블로그리스트", notes = "블로그리스트")
    public Page<BlogEntity> bloglistfindByPageNo(@PageableDefault(size = 10, sort = "seq",direction = Sort.Direction.DESC) Pageable pageable) throws Exception {


        Page<BlogEntity> blogEntities =  blogService.findByPageNo(pageable);


        return blogEntities;

    }

}
