package com.steve.academysteveback.user;

import com.steve.academysteveback.mail.MailDto;
import com.steve.academysteveback.mail.MailService;
import com.steve.academysteveback.mytrain.dto.EnrollDto;
import com.steve.academysteveback.token.JwtService;
import com.steve.academysteveback.user.dto.*;
import com.steve.academysteveback.user.service.LogService;
import com.steve.academysteveback.user.service.UserService;
import com.steve.academysteveback.util.ApiResponseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    LogService logService;

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
    public void sendAuthMail(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception {

        System.out.println("UserController.sendAuthMail");

        MailDto mailDto = new MailDto();
        mailDto.setTo(userDto.getMail());
        mailDto.setSubject("스티브리아카데미 가입인증 메일");
        mailDto.setMailTemplate("tokenMail.html");

        LogDto logDto = new LogDto();

        logDto.setUserId(userDto.getMail());
        logDto.setUserIp(request.getRemoteAddr());

        logDto.setReqUrl(request.getRequestURL().toString());


        String authNumber = mailService.sendMail(mailDto, logDto);

        System.out.println("auth:" + authNumber);

        JoinDto joinDto = new JoinDto();
        joinDto.setUserId(userDto.getMail());
        joinDto.setUserPw(authNumber);

        ApiResponseModel response = new ApiResponseModel();
        userService.join(joinDto);
        response.put(null);


    }
/*
    @GetMapping("/sendAuthMail")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public void sendAuthMailGet(@RequestParam String mail, HttpServletRequest request) throws Exception {

        MailDto mailDto = new MailDto();
        mailDto.setTo(mail);
        mailDto.setSubject("스티브리아카데미 가입인증 메일");
        mailDto.setMailTemplate("tokenMail.html");

        LogDto logDto = new LogDto();

        logDto.setUserId(mail);
        logDto.setUserIp(request.getRemoteAddr());

        logDto.setReqUrl(request.getRequestURL().toString());

        logService.logging(logDto);

        String authNumber = mailService.sendMail(mailDto, logDto);

        System.out.println("auth:" + authNumber);

        JoinDto joinDto = new JoinDto();
        joinDto.setUserId(mail);
        joinDto.setUserPw(authNumber);

        ApiResponseModel response = new ApiResponseModel();

        userService.join(joinDto);
        response.put(null);

    }
*/

    @PostMapping("/login")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public ApiResponseModel loginAction(@RequestBody LoginDto loginDto) throws Exception {
        System.out.println("LoginDto:" + loginDto);
        ApiResponseModel response = new ApiResponseModel();
        String jwtToken = userService.login(loginDto);

        if(jwtToken != null){
            System.out.println("jwtToken:" + jwtToken);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("jwtToken", jwtToken);
            map.put("userInfo", userService.getUserInfo(loginDto.getUserId()));
            response.put(map);
        }else{
            response.setResultCode(500);
        }


        return response;
    }

    @PostMapping("/agree")
    @ApiOperation(value = "비밀유지동의", notes = "비밀유지동의")
    public ApiResponseModel agreeAction(@RequestBody JoinDto joinDto) throws Exception {
        System.out.println("joinDto:" + joinDto);
        ApiResponseModel response = new ApiResponseModel();

        userService.agree(joinDto);
        response.put(null);

        return response;
    }

    @PostMapping("/tokenchk")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public ApiResponseModel tokenChk(@RequestBody JwtUserDto jwtUserDto) throws Exception {
        System.out.println("jwtUserDto:" + jwtUserDto);
        ApiResponseModel response = new ApiResponseModel();
        JwtUserDto jwtUserDto2 = jwtService.detailJwtToken(jwtUserDto.getToken());
        System.out.println("jwtUserDto2:" + jwtUserDto2);
        /*
        boolean result = jwtService.checkJwtToken(jwtUserDto.getToken());
        System.out.println("result:" + result);
        if(!result) response.setResultCode(500);
        else {
            jwtUserDto = jwtService.detailJwtToken(jwtUserDto.getToken());
            response.setData(jwtUserDto);
        }
        */
        if(jwtUserDto2.getUserType() == null) response.setResultCode(500);
        else {
            response.setData(jwtUserDto2);
        }

        return response;
    }

    @PostMapping("/logging")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public ApiResponseModel logging(@RequestBody LogDto logDto, HttpServletRequest request) throws Exception {
        System.out.println("logDto:" + logDto);
        ApiResponseModel response = new ApiResponseModel();

        System.out.println("getPathInfo:" + request.getPathInfo());
        System.out.println("getRequestURI:" + request.getRequestURI());
        System.out.println("getRemoteUser:" + request.getRemoteUser());
        System.out.println("getLocalAddr:" + request.getLocalAddr());
        System.out.println("getRemoteAddr:" + request.getRemoteAddr());
        System.out.println("getRequestURL:" + request.getRequestURL());

        if(request.getLocalAddr() != null) logDto.setUserIp(request.getRemoteAddr());
        else logDto.setUserIp(request.getRemoteAddr());

        logDto.setReqUrl(request.getRequestURL().toString());

        logService.logging(logDto);

        response.setData("ok");


        return response;
    }

}
