package com.steve.academysteveback.mail;

import com.steve.academysteveback.util.NumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class MailService {



  @Autowired
  SpringTemplateEngine templateEngine;

  private final JavaMailSender javaMailSender;


  /**
   * 메일발송
   * @param mailDto
   */
  public String sendMail(MailDto mailDto) {
    String authNumber = NumberUtil.randomNum(6);
    Context context = new Context();
    context.setVariable("emailToken", authNumber);
    context.setVariable("url", mailDto.getUrl());
    String html = templateEngine.process(mailDto.getMailTemplate(), context);

    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

      helper.setTo(mailDto.getTo());
      helper.setSubject(mailDto.getSubject());
      helper.setText(html, true);

      javaMailSender.send(message);
    } catch(MessagingException e) {
      throw new RuntimeException(e);
    }

    return authNumber;
  }
}
