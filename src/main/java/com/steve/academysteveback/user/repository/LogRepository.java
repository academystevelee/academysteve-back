package com.steve.academysteveback.user.repository;


import com.steve.academysteveback.user.entity.LogEntity;
import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, String> {

  LogEntity findByUserId(String userId);
}
