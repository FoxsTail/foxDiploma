package com.alice.service;

import com.alice.dao.UserDAO;

import com.alice.domain.UserRole;
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
    private UserDAO userDAO;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.alice.domain.User user = userDAO.findByUsername(username);
        List<GrantedAuthority> authorityList = buildUserAuthority(user.getUserRoles());

        return buildUserForAuthentification(user, authorityList);
    }


    public User buildUserForAuthentification(com.alice.domain.User user,
                                             List<GrantedAuthority> authorityList){

        return new User(user.getUsername(),user.getPassword(),user.isEnabled(),
                true,true, true, authorityList);

    }

    //Достаем сэт имя-роль(неск) данного пользователя отсекам повторения, записываем в лист

    public List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles){

        Set<GrantedAuthority> authoritySet = new HashSet<GrantedAuthority>();

        for(UserRole userRole: userRoles){
            authoritySet.add(new SimpleGrantedAuthority(userRole.getRole()));
        }


        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>(authoritySet);

        return authorityList;
    }
}

