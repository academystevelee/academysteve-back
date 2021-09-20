package com.steve.academysteveback.manage.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "user_auth")
@Getter @ToString
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_TYPE_BF")
    private String userTypeBf;

    @Column(name = "USER_TYPE_AF")
    private String userTypeAf;

    @Column(name = "REG_DT")
    private LocalDateTime regDt;

    @Column(name = "APPROVE_YN")
    private Character approveYn;

    @Column(name = "APPROVE_DT")
    private LocalDateTime approveDt;
}
