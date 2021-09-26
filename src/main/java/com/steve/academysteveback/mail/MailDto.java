package com.steve.academysteveback.mail;

import lombok.Data;

@Data
public class MailDto {

  private String to;
  private String from;
  private String mailTemplate;
  private String subject;
  private String message;
  private String url;
  private String name;

}
