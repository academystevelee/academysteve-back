package com.steve.academysteveback.lecture.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "CLASS")
public class ClassEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "CLASS_NO")
  private String classNo;

  @Column(name = "IMG_URL")
  private String imgUrl;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "TAG")
  private String tag;

  @Column(name = "TEACHER")
  private String teacher;

  @Column(name = "HIT")
  private Long hit;

  @Column(name = "REG_DT")
  private Date regDt;

  @Column(name = "CONTENTS")
  private String contents;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "TITLECOLOR")
  private String titlecolor;

  @Column(name = "DEL_YN")
  private char delYn;

  @Column(name = "ORDER")
  private Long order;

  public ClassEntity() {
    this.regDt = new Date();
  }
}
