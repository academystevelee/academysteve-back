package com.steve.academysteveback.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "AUTH_MAIL")
public class AuthMailEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "MAIL", nullable = false, length = 30)
  private String mail;

  @Column(name = "AUTH_NUMBER", nullable = false, length = 10)
  private String authNumber;

  @Column(name = "AUTH_YN", nullable = false)
  private Character authYn;

  @Column(name = "USE_YN", nullable = false)
  private Character useYn;

  @Column(name = "DEL_YN", nullable = false)
  private Character delYn;

  @Column(name = "REG_DT", nullable = false)
  private Date regDt;


  public AuthMailEntity() {
    this.authYn = 'N';
    this.useYn = 'N';
    this.delYn = 'N';
    this.regDt = new Date();
  }
}
