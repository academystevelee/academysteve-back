package com.steve.academysteveback.manage;

import com.steve.academysteveback.manage.entity.UserAuth;
import com.steve.academysteveback.manage.repository.UserAuthRepository;
import com.steve.academysteveback.manage.service.ManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {

    private final UserAuthRepository userAuthRepository;
    private final ManageService manageService;

    @GetMapping("/promotionlist")
    public List<UserAuth> getLists() {
        System.out.println("ManageController.getLists");
        return userAuthRepository.findByApproves('N');
    }

//    승격요청 유저 승격허용
    @PutMapping("/reqpromotion")
    public String reqPromotion(@RequestBody List<String> data) {
        System.out.println("data = " + data);
        return "서버 개발진행중..";
    }
}
