package com.steve.academysteveback.mytrain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "ENROLL")
public class EnrollEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "USER_ID", nullable = false, unique = true, length = 30)
  private String userId;

  @Column(name = "CLASS_NO")
  private String classNo;

  @Column(name = "AGE")
  private String age;

  @Column(name = "GENDER")
  private String gender;

  @Column(name = "MAJOR")
  private String major;

  @Column(name = "JOB_AGE")
  private String jobAge;

  @Column(name = "DATE")
  private String date;

  @Column(name = "REASON")
  private String reason;

  @Column(name = "REG_DT")
  private Date regDt;

  @Column(name = "STATUS")
  private String status;

  public EnrollEntity() {

    this.regDt = new Date();
    this.status = "신청완료";
  }
}
