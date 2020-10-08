package com.qssi_wms.ephs.shared.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qssi_wms.ephs.shared.common.dto.UserDto;
import com.qssi_wms.ephs.shared.common.entity.UserEntity;
import com.qssi_wms.ephs.shared.common.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserId(userId);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userId));
        } else {
            return JwtUserFactory.create(new UserDto(user.getUserId(), user.getPassword(), user.getName()));
        }
    }
}
