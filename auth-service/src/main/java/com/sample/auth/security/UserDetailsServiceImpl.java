package com.sample.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.auth.dto.UserDto;
import com.sample.auth.entity.UserEntity;
import com.sample.auth.repository.UserRepository;



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
