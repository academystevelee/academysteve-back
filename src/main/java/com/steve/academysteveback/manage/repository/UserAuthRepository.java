package com.steve.academysteveback.manage.repository;

import com.steve.academysteveback.manage.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    @Query("select ua from user_auth ua where ua.approveYn = ?1")
    List<UserAuth> findByApproves(Character condition);

//    @Query("update user_auth ua set ua.approveYn = 'Y' where ua.userSeq in (?1)")
//    void userReqPromotion(String data);
}
