package com.steve.academysteveback.user.dto;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
public class UserDto {
    private String userPass;
    private String key;
    private String mail;

    public String getUserPass() {
        return BCrypt.hashpw(this.userPass, BCrypt.gensalt());
    }
}
