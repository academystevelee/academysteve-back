package com.steve.academysteveback.util.commoncode;


import com.steve.academysteveback.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonRepository extends JpaRepository<CommonEntity, String> {

  CommonEntity findByCode1AndCode2(String code1,String code2);
}
