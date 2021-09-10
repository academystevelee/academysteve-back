package com.steve.academysteveback.blog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BlogDto {

  private Long seq;
  private String cate;
  private String title;
  private String content;
  private String userId;
  private Long hit;

}
