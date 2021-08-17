package com.steve.academysteveback.user;

import com.steve.academysteveback.mail.MailDto;
import com.steve.academysteveback.mail.MailService;
import com.steve.academysteveback.user.dto.UserDto;
import com.steve.academysteveback.user.entity.AuthMailEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    MailService mailService;

//    @Autowired
//    UserService userService;
    @ApiOperation(value = "호출테스트", notes = "api호출테스트.")
    @GetMapping("/test")
    public String test(){

        return "test";
    }

    /**
     * 인증메일 발송
     *

    @PostMapping("/sendAuthMail")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public void sendAuthMail(@RequestBody String mail) throws Exception {

        MailDto mailDto = new MailDto();
        mailDto.setTo(mail);
        mailDto.setSubject("스티브리아카데미 가입인증 메일");
        mailDto.setMailTemplate("tokenMail.html");

        String authNumber = mailService.sendMail(mailDto);

        System.out.println("auth:" + authNumber);

        AuthMailEntity authMail = new AuthMailEntity();
        authMail.setMail(mail);
        authMail.setAuthNumber(authNumber);
        //userService.saveAuthMail(authMail);
    }
     */


    @PostMapping("/sendAuthMail")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public void sendAuthMail(@RequestBody UserDto userDto) throws Exception {

        MailDto mailDto = new MailDto();
        mailDto.setTo(userDto.getMail());
        mailDto.setSubject("스티브리아카데미 가입인증 메일");
        mailDto.setMailTemplate("tokenMail.html");

        String authNumber = mailService.sendMail(mailDto);

        System.out.println("auth:" + authNumber);
    }

    @GetMapping("/sendAuthMail")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public void sendAuthMailGet(@RequestParam String mail) throws Exception {

        MailDto mailDto = new MailDto();
        mailDto.setTo(mail);
        mailDto.setSubject("스티브리아카데미 가입인증 메일");
        mailDto.setMailTemplate("tokenMail.html");

        String authNumber = mailService.sendMail(mailDto);

        System.out.println("auth:" + authNumber);
    }
}
