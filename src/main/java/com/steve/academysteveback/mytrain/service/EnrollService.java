package com.steve.academysteveback.mytrain.service;


import com.steve.academysteveback.mytrain.dto.EnrollDto;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import com.steve.academysteveback.mytrain.repository.EnrollRepository;
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
public class EnrollService {

  @Autowired
  EnrollRepository enrollRepository;


  ModelMapper modelMapper = new ModelMapper();


  /**
   * 회원가입
   * @param enrollDto
   */
  public void join(EnrollDto enrollDto) {

    EnrollEntity enrollEntity = modelMapper.map(enrollDto, EnrollEntity.class);

    enrollRepository.save(enrollEntity);
  }




}
