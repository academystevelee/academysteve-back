package com.steve.academysteveback.lecture.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClassDto {

  private Long seq;
  private String classNo;
  private String imgUrl;
  private String title;
  private String tag;
  private String teacher;
  private Long hit;
  private Date regDt;
  private String contents;
  private String status;
  private String titlecolor;
  private char delYn;
  private Long order;

}
