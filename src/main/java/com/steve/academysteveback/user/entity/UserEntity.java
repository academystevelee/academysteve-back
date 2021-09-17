package com.steve.academysteveback.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "USER")
public class UserEntity {

  @Id
  @Column(name = "USER_SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userSeq;

  @Column(name = "USER_ID", nullable = false, unique = true, length = 30)
  private String userId;

  @Column(name = "USER_PW", nullable = false, length = 100)
  private String userPw;

  @Column(name = "USER_NAME", length = 30)
  private String userName;

  @Column(name = "USER_TYPE", length = 10)
  private String userType;

  @Column(name = "USER_BIRTH", length=8)
  private String userBirth;

  @Column(name = "USER_PHONE", length=15)
  private String userPhone;

  @Column(name = "SUBWAY", length=15)
  private String subway;

  @Column(name = "REG_DT")
  private Date regDt;

  @Column(name = "LOGIN_DT")
  private Date loginDt;

  @Column(name = "UPDATE_ID")
  private Long updateId;

  @Column(name = "UPDATE_DT")
  private Date updateDt;

  @Column(name = "MARKET_YN")
  private Character marketYn;

  @Column(name = "MARKET_DT")
  private Date marketDt;

  @Column(name = "DORMANT_YN")
  private Character dormantYn;

  @Column(name = "DORMANT_DT")
  private Date dormantDt;

  @Column(name = "DEL_YN")
  private Character delYn;

  @Column(name = "DEL_DT")
  private Date delDt;

  @Column(name = "AGREE_YN")
  private Character agreeYn;


  public UserEntity() {
    this.userType = "USER";
    this.regDt = new Date();
    this.regDt = new Date();
    this.marketDt = new Date();
    this.dormantYn = 'N';
    this.delYn = 'N';
  }
}
