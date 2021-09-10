package com.steve.academysteveback.lecture.service;


import com.steve.academysteveback.lecture.dto.ClassDto;
import com.steve.academysteveback.lecture.entity.ClassDtEntity;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.lecture.repository.ClassDtRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassDtService {

  @Autowired
  ClassDtRepository classDtRepository;


  ModelMapper modelMapper = new ModelMapper();


  /**
   * 강좌조회
   */
  public List<ClassDtEntity> all() {


    List<ClassDtEntity> classDtlist = classDtRepository.findAll();
    return classDtlist;
  }

  /**
   * 강좌조회
   */
  public List<ClassDtEntity> findByClassNo(String classNo) {


    List<ClassDtEntity> classDtlist = classDtRepository.findByClassNo(classNo);
    return classDtlist;
  }

  /**
   * 강좌등록
   * @param classlDto
   */
  public void register(ClassDto classlDto) {

    ClassEntity classEntity = modelMapper.map(classlDto, ClassEntity.class);

    //classRepository.save(classEntity);
  }




}
