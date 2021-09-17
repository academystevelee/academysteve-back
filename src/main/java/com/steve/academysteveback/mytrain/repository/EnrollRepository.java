package com.steve.academysteveback.mytrain.repository;


import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, String> {

  EnrollEntity findByUserId(String userId);
  List<EnrollEntity> findByUserIdAndStatus(String userId,String status);
}
