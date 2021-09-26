package com.steve.academysteveback.util.commoncode;

import com.steve.academysteveback.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonCodeService {
    @Autowired
    CommonRepository commonRepository;
    public CommonEntity findCodeName(CommonDto commonDto){
       CommonEntity commonEntity =   commonRepository.findByCode1AndCode2(commonDto.getCode1(), commonDto.getCode2());

       return commonEntity;
    }

}
