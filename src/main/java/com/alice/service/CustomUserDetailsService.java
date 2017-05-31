package com.alice.service;

import com.alice.dao.UserDAO;

import com.alice.domain.Role;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 025 25.04.17.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.alice.domain.User user = userService.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        System.out.println("User for login : "+ user.getUsername());

        Set<GrantedAuthority> authorityList = buildUserAuthority(user.getRoles());

        return buildUserForAuthentification(user, authorityList);
    }


    private User buildUserForAuthentification(com.alice.domain.User user,
                                              Set<GrantedAuthority> authorityList){
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        return new User(user.getUsername(),user.getPassword(),user.isEnabled(),
                accountNonExpired ,credentialsNonExpired, accountNonLocked, authorityList);

    }

    private Set<GrantedAuthority> buildUserAuthority(Set<Role> userRoles){

        Set<GrantedAuthority> authoritySet = new HashSet<GrantedAuthority>();
        System.out.println("Уровень выборки");
        for(Role userRole: userRoles){
            authoritySet.add(new SimpleGrantedAuthority("ROLE_"+ userRole.getRole()));
            System.out.println("His role : "+ userRole);
        }
        return new HashSet<GrantedAuthority>(authoritySet);
    }
}

