package com.steve.academysteveback.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime regDt;

  @Column(name = "UPD_DT")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updDt;

  public BlogEntity() {
    this.regDt = LocalDateTime.now();
    this.updDt = LocalDateTime.now();
  }
}
