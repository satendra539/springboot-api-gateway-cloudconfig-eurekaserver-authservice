package com.sample.auth.security;

import com.sample.auth.dto.UserDto;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserDto user) {
        return new JwtUser(
                user.getUserId(),
                user.getPassword()     
        );
    }

}
