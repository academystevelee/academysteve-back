package com.steve.academysteveback.user.dto;

import lombok.Data;

@Data
public class JwtUserDto {

  private Long seq;
  private String userId;
  private String userType;
}
