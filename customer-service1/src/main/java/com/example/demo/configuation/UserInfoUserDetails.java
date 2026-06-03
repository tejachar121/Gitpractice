package com.example.demo.configuation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Customer;

public class UserInfoUserDetails implements UserDetails {  // UserDetailsImp class


    private String cname;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(Customer userInfo) {
        cname=userInfo.getCname();
        password=userInfo.getPassword();
        authorities= Arrays.stream(userInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new) // .map(str -> new SimpleGrantedAuthority(str))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return cname;
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
}
