package com.steve.academysteveback.user.repository;


import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  UserEntity findByUserId(String userId);
}
