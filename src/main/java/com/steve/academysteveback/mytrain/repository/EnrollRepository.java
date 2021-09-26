package com.steve.academysteveback.mytrain.repository;


import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, String> {

  EnrollEntity findBySeq(Long seq);
  List<EnrollEntity> findByUserId(String userId);
  EnrollEntity findByUserIdAndClassNo(String userId,String ClassNo);
  List<EnrollEntity> findByUserIdAndStatus(String userId,String status);
  List<EnrollEntity> findByUserIdAndStatusAndCancelYn(String userId,String status,String cancelYn);

}
