package com.steve.academysteveback.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "PASS_MAIL")
public class PassUpdateMailEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "MAIL", nullable = false, length = 30)
  private String mail;

  @Column(name = "URL", nullable = false, length = 50)
  private String url;

  @Column(name = "USE_YN", nullable = false)
  private Character useYn;

  @Column(name = "DEL_YN", nullable = false)
  private Character delYn;

  @Column(name = "REG_DT", nullable = false)
  private Date regDt;


  public PassUpdateMailEntity() {
    this.useYn = 'N';
    this.delYn = 'N';
    this.regDt = new Date();
  }
}
