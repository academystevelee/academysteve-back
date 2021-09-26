package com.steve.academysteveback.user.service;


import com.steve.academysteveback.token.JwtService;
import com.steve.academysteveback.user.dto.JoinDto;
import com.steve.academysteveback.user.dto.LoginDto;
import com.steve.academysteveback.user.entity.UserEntity;
import com.steve.academysteveback.user.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  JwtService jwtService;

  ModelMapper modelMapper = new ModelMapper();
  /**
   * 로그인
   * @param loginDto
   */
  @Transactional
  public String login(LoginDto loginDto) {
    String jwtToken;
    UserEntity userEntity = userRepository.findByUserId(loginDto.getUserId());
    System.out.println("login userEntity:" + userEntity);

    if(userEntity != null) {
      if(BCrypt.checkpw(loginDto.getUserPw(), userEntity.getUserPw())) {
        userEntity.setLoginDt(new Date());
        return jwtToken = jwtService.createJwtToken(userEntity.getUserSeq().toString(), userEntity.getUserId(), userEntity.getUserType(), userEntity.getBlack());
      }
    }
    return null;
  }


  /**
   * 회원가입
   * @param joinDto
   */
  public void join(JoinDto joinDto) {
    UserEntity userEntity = userRepository.findByUserId(joinDto.getUserId());
    if(userEntity == null) userEntity = modelMapper.map(joinDto, UserEntity.class);
    else {
      userEntity.setUserPw(joinDto.getUserPw());
      userEntity.setUpdateDt(new Date());
    }
    userRepository.save(userEntity);
  }

  /**
   * 회원가입
   * @param joinDto
   */
  public void agree(JoinDto joinDto) {
    UserEntity userEntity = userRepository.findByUserId(joinDto.getUserId());
    userEntity.setUserName(joinDto.getUserName());
    userEntity.setUserPhone(joinDto.getUserPhone());
    userEntity.setUpdateDt(new Date());
    userEntity.setAgreeYn('Y');
    userRepository.save(userEntity);
  }




  /**
   * 사용자계정 존재여부 확인
   * @param userId
   */
  public boolean checkId(String userId) {
    UserEntity userEntity = userRepository.findByUserId(userId);
    return userEntity == null ? true : false;
  }

  /**
   * 사용자계정 존재여부 확인
   * @param userId
   */
  public UserEntity getUserInfo(String userId) {
    return userRepository.findByUserId(userId);
  }
}
