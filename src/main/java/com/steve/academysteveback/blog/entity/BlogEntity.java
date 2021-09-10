package com.steve.academysteveback.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "BLOG")
public class BlogEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "CATE")
  private String cate;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "HIT")
  private Long hit;

  @Column(name = "REG_DT")
  private Date regDt;

  @Column(name = "UPD_DT")
  private Date updDt;





  public BlogEntity() {

    this.regDt = new Date();
    this.updDt = new Date();
  }
}
