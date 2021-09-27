package com.steve.academysteveback.sms;


import com.steve.academysteveback.user.entity.AuthSmsEntity;
import com.steve.academysteveback.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class SmsService {

  @Value("${sms.api-key}")
  String apiKey;

  @Value("${sms.api-secret}")
  String apiSecret;

  @Value("${sms.from}")
  String from;

  @Autowired
  AuthSmsRepository authSmsRepository;

  /**
   * 인증문자 발송
   * @param userMobile
   */
  public String sendAuthSms(String userMobile) throws CoolsmsException {
    Message coolSms = new Message(apiKey, apiSecret);
    String authNumber = NumberUtil.randomNum(6);

    System.out.println("sms apiKey:" + apiKey);
    System.out.println("sms apiSecret:" + apiSecret);
    System.out.println("sms userMobile:" + userMobile);
    System.out.println("sms from:" + from);

    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", userMobile);
    params.put("from", from);
    params.put("type", "SMS");
    params.put("text", "인증번호는 [" + authNumber + "] 입니다.");
    params.put("app_version", "app 1.2");

    try {
      JSONObject obj = coolSms.send(params);
      String successCount = obj.get("success_count").toString();
      String errorCount = obj.get("error_count").toString();
      System.out.println("sms try");
    } catch(CoolsmsException e) {
      log.error(e.getMessage());
      System.out.println("sms catch1");
    } catch(Exception e) {
      log.error(e.getMessage());
      System.out.println("sms catch2");
    }

    return authNumber;
  }


  /**
   * 인증문자로 발송한 인증번호 저장
   * @param authMail
   */
  public void saveAuthSms(AuthSmsEntity authMail) {
    authSmsRepository.save(authMail);
  }


  /**
   * 인증문자의 인증번호 확인
   * @param authPhone
   * @param authNumber
   */
  public boolean checkAuthSms(String authPhone, String authNumber) {
    boolean checkYn;
    AuthSmsEntity authSms = authSmsRepository.findByPhoneAndAuthNumberAndUseYn(authPhone, authNumber, 'N');
    checkYn = authSms == null ? false : true;
    return checkYn;
  }
}