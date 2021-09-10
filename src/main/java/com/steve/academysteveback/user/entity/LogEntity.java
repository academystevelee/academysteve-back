package com.steve.academysteveback.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "LOG")
public class LogEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "LOCATION")
  private String location;

  @Column(name = "REQ_URL")
  private String reqUrl;

  @Column(name = "USER_IP")
  private String userIp;

  @Column(name = "REG_DT")
  private Date regDt;




  public LogEntity() {
    this.regDt = new Date();
  }
}
