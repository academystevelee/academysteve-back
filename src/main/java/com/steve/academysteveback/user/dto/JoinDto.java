package com.steve.academysteveback.user.dto;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
public class JoinDto {

  private String userId;
  private String userPw;
  private String userName;
  private String userPhone;
  private String userBirth;
  private String subway;
  private String mailAuthNumber;
  private String phoneAuthNumber;
  private Character marketYn;
  private Character agreeYn;


  public String getUserPw() {
    return BCrypt.hashpw(this.userPw, BCrypt.gensalt());
  }
}
