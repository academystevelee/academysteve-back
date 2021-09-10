package com.steve.academysteveback.user.service;


import com.steve.academysteveback.token.JwtService;
import com.steve.academysteveback.user.dto.JoinDto;
import com.steve.academysteveback.user.dto.LogDto;
import com.steve.academysteveback.user.dto.LoginDto;
import com.steve.academysteveback.user.entity.LogEntity;
import com.steve.academysteveback.user.entity.UserEntity;
import com.steve.academysteveback.user.repository.LogRepository;
import com.steve.academysteveback.user.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class LogService {

  @Autowired
  LogRepository logRepository;

  @Autowired
  JwtService jwtService;

  ModelMapper modelMapper = new ModelMapper();
  /**
   * 로그인
   * @param logDto
   */
  @Transactional
  public void logging(LogDto logDto) {
    LogEntity logEntity = new LogEntity();
    logEntity = modelMapper.map(logDto,LogEntity.class);
    logRepository.save(logEntity);


  }


}
