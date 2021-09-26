package com.steve.academysteveback.util.commoncode;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "COMMON_CODE")
public class CommonEntity {

  @Id
  @Column(name = "SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Column(name = "CODE1")
  private String code1;
  @Column(name = "CODE2")
  private String code2;
  @Column(name = "CODENAME")
  private String codename;


}
