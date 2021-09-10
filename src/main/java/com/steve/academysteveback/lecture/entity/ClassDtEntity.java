package com.steve.academysteveback.lecture.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "CLASS_DT")
public class ClassDtEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "CLASS_NO")
  private String classNo;

  @Column(name = "ENROLL_DT")
  private String enrollDt;

  @Column(name = "REG_DT")
  private Date regDt;




  public ClassDtEntity() {
    this.regDt = new Date();
  }
}
