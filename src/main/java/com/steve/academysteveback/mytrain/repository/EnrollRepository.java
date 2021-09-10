package com.steve.academysteveback.mytrain.repository;


import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, String> {

  EnrollEntity findByUserId(String userId);
}
