package com.sample.auth.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;

    
    public JwtUser(String userId, String password ) {
        this.userName = userId;
        this.password = password;
     
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getUsername() {

		return this.userName;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

}
