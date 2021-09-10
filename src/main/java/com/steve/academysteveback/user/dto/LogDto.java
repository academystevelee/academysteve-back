package com.steve.academysteveback.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LogDto {

  private Long seq;
  private String userId;
  private String location;
  private String reqUrl;
  private String userIp;


}
