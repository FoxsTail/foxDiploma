package com.alice.service;

import com.alice.domain.User;

import java.util.List;

/**
 * Created by User on 030 30.03.17.
 */
public interface UserService {

    public void addUser(User user);

    public List<User> listUser();

    public void removeUser(String username);

    public String getPrincipal();
}
