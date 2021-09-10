package com.steve.academysteveback.lecture.repository;


import com.steve.academysteveback.lecture.entity.ClassDtEntity;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDtRepository extends JpaRepository<ClassDtEntity, String> {

  List<ClassDtEntity> findByClassNo(String classNo);
}
