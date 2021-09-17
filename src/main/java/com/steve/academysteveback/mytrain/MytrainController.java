package com.steve.academysteveback.mytrain;

import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mail.MailDto;
import com.steve.academysteveback.mail.MailService;
import com.steve.academysteveback.mytrain.dto.EnrollDoneDto;
import com.steve.academysteveback.mytrain.dto.EnrollDto;
import com.steve.academysteveback.mytrain.entity.EnrollEntity;
import com.steve.academysteveback.mytrain.service.EnrollService;
import com.steve.academysteveback.token.JwtService;
import com.steve.academysteveback.user.dto.JoinDto;
import com.steve.academysteveback.user.dto.JwtUserDto;
import com.steve.academysteveback.user.dto.LoginDto;
import com.steve.academysteveback.user.dto.UserDto;
import com.steve.academysteveback.user.service.UserService;
import com.steve.academysteveback.util.ApiResponseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MytrainController {



    @Autowired
    EnrollService enrollService;

    @PostMapping("/enroll")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public void tokenChk(@RequestBody EnrollDto enrollDto) throws Exception {
        System.out.println("enroll ok : " + enrollDto) ;
        enrollDto.setStatus("신청완료");

        enrollService.join(enrollDto);


    }

    @GetMapping("/enroll/{userId}")
    @ApiOperation(value = "클래스 상세", notes = "클래스 상세")
    public List<EnrollDoneDto> classfindByClassNo(@PathVariable String userId) throws Exception {
        List<EnrollDoneDto> enrolllist = enrollService.findDone(userId);

        return enrolllist;

    }
}
