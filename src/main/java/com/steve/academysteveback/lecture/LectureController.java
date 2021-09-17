package com.steve.academysteveback.lecture;

import com.steve.academysteveback.lecture.dto.ClassDto;
import com.steve.academysteveback.lecture.dto.EnrollPageDto;
import com.steve.academysteveback.lecture.entity.ClassEntity;
import com.steve.academysteveback.lecture.entity.ClassDtEntity;
import com.steve.academysteveback.lecture.service.ClassDtService;
import com.steve.academysteveback.lecture.service.ClassService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/lecture")
@RestController
public class LectureController {



    @Autowired
    ClassService classService;

    @Autowired
    ClassDtService classDtService;

    @GetMapping("/all")
    @ApiOperation(value = "클래스 리스트", notes = "클래스 리스트")
    public List<ClassEntity> all() throws Exception {
        List<ClassEntity> classlist = classService.all();

        return classlist;

    }

    @GetMapping("/class/{classno}")
    @ApiOperation(value = "클래스 상세", notes = "클래스 상세")
    public ClassEntity classfindByClassNo(@PathVariable String classno) throws Exception {
        ClassEntity classEntity = classService.findByClassNo(classno);

        return classEntity;

    }

    @GetMapping("/classdt/{classno}")
    @ApiOperation(value = "클래스 수강일", notes = "클래스 수강일")
    public List<ClassDtEntity> classdtfindByClassNo(@PathVariable String classno) throws Exception {
        System.out.println("classno ok : " + classno) ;
        List<ClassDtEntity> classDtlist = classDtService.findByClassNo(classno);

        return classDtlist;

    }

    @GetMapping("/enrollpage/{classno}")
    @ApiOperation(value = "인증메일 발송", notes = "인증메일을 발송한다.")
    public EnrollPageDto enrollpagefindByClassNo(@PathVariable String classno) throws Exception {
        System.out.println("classno ok : " + classno) ;
        List<ClassDtEntity> classDtlist = classDtService.findByClassNo(classno);
        ClassEntity classEntity = classService.findByClassNo(classno);

        EnrollPageDto enrollPageDto = new EnrollPageDto();
        enrollPageDto.setClassDtList(classDtlist);
        enrollPageDto.setClassEntity(classEntity);

        return enrollPageDto;

    }

    @PostMapping("/register")
    @ApiOperation(value = "로그인처리", notes = "로그인처리")
    public void lecture(@RequestBody ClassDto classlDto) throws Exception {
        System.out.println("classlDto ok : " + classlDto) ;

        classService.register(classlDto);


    }

}
