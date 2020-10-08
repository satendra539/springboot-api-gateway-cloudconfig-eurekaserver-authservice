package com.qssi_wms.ephs.shared.common.security;

import com.qssi_wms.ephs.shared.common.dto.UserDto;

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
