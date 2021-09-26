package com.steve.academysteveback.mytrain;

import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.mail.MailDto;
import com.steve.academysteveback.mail.MailService;
import com.steve.academysteveback.mytrain.dto.EnrollClassDto;
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
    @ApiOperation(value = "수강등록", notes = "수강등록")
    public void enroll(@RequestBody EnrollDto enrollDto) throws Exception {
        System.out.println("enroll ok : " + enrollDto) ;
        enrollDto.setStatus("신청완료");
        enrollDto.setCancelYn("N");

        enrollService.join(enrollDto);


    }

    @PostMapping("/enrollUpdate")
    @ApiOperation(value = "수강등록수정", notes = "수강등록수정")
    public void enrollUpdate(@RequestBody EnrollDto enrollDto) throws Exception {

        enrollService.enrollUpdate(enrollDto);


    }

    @PostMapping("/enrollone")
    @ApiOperation(value = "등록정보", notes = "등록정보")
    public EnrollEntity enrollone(@RequestBody EnrollDto enrolldto) throws Exception {
        EnrollEntity enrollEntity = enrollService.findOne(enrolldto);

        return enrollEntity;

    }


    @GetMapping("/enroll/{userId}")
    @ApiOperation(value = "등록리스트", notes = "등록리스트")
    public List<EnrollDoneDto> classfindByClassNo(@PathVariable String userId) throws Exception {
        List<EnrollDoneDto> enrolllist = enrollService.findDone(userId);

        return enrolllist;

    }

    @GetMapping("/enrolllist/{userId}")
    @ApiOperation(value = "등록클래스리스트", notes = "등록클래스리스트")
    public List<EnrollClassDto> enrolllist(@PathVariable String userId) throws Exception {
        List<EnrollClassDto> enrollClassDtos = enrollService.findDoneList(userId);

        return enrollClassDtos;

    }
/*
    @GetMapping("/enrollDone/{userId}")
    @ApiOperation(value = "클래스 상세", notes = "클래스 상세")
    public void enrollDone(@PathVariable String userId) throws Exception {

        enrollService.enrollDone(userId);

    }
*/
    @PostMapping("/enrollDone")
    @ApiOperation(value = "신청완료", notes = "신청완료")
    public void enrollDone(@RequestBody EnrollDto enrolldto) throws Exception {
        enrollService.enrollDone(enrolldto);

    }
}
