package com.steve.academysteveback.sms;

import com.steve.academysteveback.user.entity.AuthSmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthSmsRepository extends JpaRepository<AuthSmsEntity, String> {

  AuthSmsEntity findByPhoneAndAuthNumber(String phone, String authNumber);
  AuthSmsEntity findByPhoneAndAuthNumberAndUseYn(String phone, String authNumber, Character userYn);
}
