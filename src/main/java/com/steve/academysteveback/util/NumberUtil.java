package com.steve.academysteveback.util;

import java.util.Random;

public class NumberUtil {

  /**
   * 랜덤숫자 생성
   * @param length
   * @return
   */
  public static String randomNum(int length) {
    String result = "";
    Random random = new Random(System.currentTimeMillis());

    for(int i=0; i<length; i++) {
      result += Integer.toString(random.nextInt(10));
    }

    return result;
  }
}
