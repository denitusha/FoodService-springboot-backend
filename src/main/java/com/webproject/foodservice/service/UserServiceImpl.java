package com.webproject.foodservice.service;

import com.webproject.foodservice.DAO.UserRepository;
import com.webproject.foodservice.entity.Role;
import com.webproject.foodservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
//        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
//    }


}
