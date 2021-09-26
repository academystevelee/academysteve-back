package com.steve.academysteveback.mytrain.dto;

import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import lombok.Data;

@Data
public class EnrollClassDto {

  private EnrollEntity enrollEntity;
  private ClassEntity classEntity;

}
