package com.steve.academysteveback.lecture.service;


import com.steve.academysteveback.lecture.dto.ClassDto;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.lecture.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

  @Autowired
  ClassRepository classRepository;


  ModelMapper modelMapper = new ModelMapper();


  /**
   * 강좌조회
   */
  public List<ClassEntity> all() {


    List<ClassEntity> classlist = classRepository.findAll(Sort.by(Sort.Direction.ASC,"order"));
    return classlist;
  }

  /**
   * 강좌조회
   */
  public ClassEntity findByClassNo(String classNo) {


    ClassEntity classEntity = classRepository.findByClassNo(classNo);
    classEntity.setHit(classEntity.getHit() + 1);
    classRepository.updateBySeq(classEntity);
    return classEntity;
  }

  /**
   * 강좌등록
   * @param classlDto
   */
  public void register(ClassDto classlDto) {

    ClassEntity classEntity = modelMapper.map(classlDto, ClassEntity.class);

    classRepository.save(classEntity);
  }




}
