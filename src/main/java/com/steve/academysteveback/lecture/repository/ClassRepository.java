package com.steve.academysteveback.lecture.repository;


import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, String> {

  ClassEntity findByClassNo(String classNo);

}
