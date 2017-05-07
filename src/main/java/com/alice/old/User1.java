package com.alice.old;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by User on 025 25.04.17.
 */
public class User1 implements UserDetails {
    private static final long serialVersionUID = 8266525488057072269L;
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public User1(String username, String password, String roles) {
        super();
        this.username = username;
        this.password = password;
        this.setRoles(roles);
    }

    public void setRoles(String roles) {
        this.authorities = new HashSet<GrantedAuthority>();
        for (final String role : roles.split(",")) {
            if (role != null && !"".equals(role.trim())) {
                GrantedAuthority grandAuthority = new GrantedAuthority() {
                    private static final long serialVersionUID = 3958183417696804555L;

                    public String getAuthority() {
                        return role.trim();
                    }
                };
                this.authorities.add(grandAuthority);
            }
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    /**
     * Created by User on 025 25.04.17.
     */
    @Service
    public static class UserManager {
        private HashMap<String, User1> users;

        public UserManager() {
            users = new HashMap<String, User1>();
            users.put("john", new User1("john", "1", "ROLE_USER"));
            users.put("bob", new User1("bob", "2", "ROLE_USER, ROLE_ADMIN"));
        }

        public User1 getUser(String username) throws UsernameNotFoundException {
            if( !users.containsKey( username ) ){
                throw new UsernameNotFoundException( username + " not found" );
            }

            return users.get( username );
        }
    }
}
