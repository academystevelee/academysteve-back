package com.steve.academysteveback.token;

import com.steve.academysteveback.user.dto.JwtUserDto;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

  /**
   * jwt토큰 생성
   * @param id
   * @param userType
   * @return
   */
  public String createJwtToken(String userSeq, String id, String userType) {
    JwtBuilder builder = Jwts.builder();

    Map<String, Object> headers = new HashMap<>();
    headers.put("typ", "JWT");
    headers.put("alg", "HS256");

    Map<String, Object> payloads = new HashMap<>();
    payloads.put("userSeq", userSeq);
    payloads.put("userId", id);
    payloads.put("userType", userType);

    SignatureAlgorithm alg = SignatureAlgorithm.HS256;
    byte[] secretKey = JwtProperties.SECRET.getBytes();

    Date ext = new Date();
    ext.setTime(ext.getTime() + JwtProperties.EXPIRATION_TIME);


    String jwt = Jwts.builder()
            .setHeader(headers)
            .setClaims(payloads)
            .signWith(alg, secretKey)
            .setSubject("userAuth")
            .setExpiration(ext)
            .compact();

    return jwt;
  }


  /**
   * jwt토큰 검증
   * @param jwt
   * @return
   */
  static public boolean checkJwtToken(String jwt) {
    try {
      Jwts.parser().setSigningKey(JwtProperties.SECRET.getBytes()).parseClaimsJws(jwt);
      return true;
    } catch (SecurityException e) {
      log.info("Invalid JWT signature.");
    } catch (MalformedJwtException e) {
      log.info("Invalid JWT token.");
    } catch (ExpiredJwtException e) {
      log.info("Expired JWT token.");
    } catch (UnsupportedJwtException e) {
      log.info("Unsupported JWT token.");
    } catch (IllegalArgumentException e) {
      log.info("JWT token compact of handler are invalid.");
    } finally {
      return false;
    }
  }


  /**
   * jwt토큰정보 확인
   * @param jwt
   * @return
   */
  public JwtUserDto detailJwtToken(String jwt) {
    JwtUserDto jwtUserDto = new JwtUserDto();

    try {
      Claims claims = Jwts.parser()
              .setSigningKey(JwtProperties.SECRET.getBytes())
              .parseClaimsJws(jwt)
              .getBody();

      Date expiration = claims.get("exp", Date.class);
      jwtUserDto.setSeq(Long.parseLong(claims.get("userSeq", String.class)));
      jwtUserDto.setUserId(claims.get("userId", String.class));
      jwtUserDto.setUserType(claims.get("userType", String.class));

      if(!(expiration.getTime() - new Date().getTime() > 0)) {
        System.out.println("유효시간 만료");
      }
    } catch(SecurityException e) {
      log.info("Invalid JWT signature.");
    } catch(MalformedJwtException e) {
      log.info("Invalid JWT token.");
    } catch(ExpiredJwtException e) {
      log.info("Expired JWT token.");
    } catch(UnsupportedJwtException e) {
      log.info("Unsupported JWT token.");
    } catch(IllegalArgumentException e) {
      log.info("JWT token compact of handler are invalid.");
    }

    return jwtUserDto;
  }
}
