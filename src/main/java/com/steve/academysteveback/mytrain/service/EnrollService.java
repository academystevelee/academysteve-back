package com.steve.academysteveback.mytrain.service;


import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.lecture.repository.ClassRepository;
import com.steve.academysteveback.mytrain.dto.EnrollDoneDto;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnrollService {

  @Autowired
  EnrollRepository enrollRepository;

  @Autowired
  ClassRepository classRepository;


  ModelMapper modelMapper = new ModelMapper();


  /**
   * 수강신청
   * @param enrollDto
   */
  public void join(EnrollDto enrollDto) {

    EnrollEntity enrollEntity = modelMapper.map(enrollDto, EnrollEntity.class);

    enrollRepository.save(enrollEntity);
  }

  /**
   * 수강완료조회
   * @param userId
   */
  public List<EnrollDoneDto> findDone(String userId) {
    List<EnrollEntity> enrolllist = enrollRepository.findByUserIdAndStatus(userId,"승인완료");


    List<EnrollDoneDto> enrolldonelist = new ArrayList<>();

    for(EnrollEntity item:enrolllist){
      EnrollDoneDto enrollDoneDto = modelMapper.map(item, EnrollDoneDto.class);
      ClassEntity centity = classRepository.findByClassNo(item.getClassNo());
      enrollDoneDto.setClassTitle(centity.getTitle());

      enrolldonelist.add(enrollDoneDto);

    }


    return enrolldonelist;
  }



}
