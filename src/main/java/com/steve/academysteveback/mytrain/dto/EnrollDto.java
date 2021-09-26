package com.steve.academysteveback.mytrain.dto;

import lombok.Data;

@Data
public class EnrollDto {

  private Long seq;
  private String userId;
  private String classNo;
  private String age;
  private String gender;
  private String major;
  private String jobAge;
  private String date;
  private String reason;
  private String status;
  private String cancelYn;
  private String agreeYn;

}
