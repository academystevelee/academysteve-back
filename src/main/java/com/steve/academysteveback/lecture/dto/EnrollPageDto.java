package com.steve.academysteveback.lecture.dto;

import com.steve.academysteveback.lecture.entity.ClassDtEntity;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import lombok.Data;

import java.util.List;

@Data
public class EnrollPageDto {
    private List<ClassDtEntity> classDtList;
    private ClassEntity classEntity;

}
