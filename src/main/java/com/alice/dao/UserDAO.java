package com.alice.dao;

import com.alice.domain.User;

import java.util.List;

/**
 * Created by User on 019 19.03.17.
 */
public interface UserDAO {

    public void addUser(User user);
    public List<User> listUser();
    public void removeUser(String username);
    public User findByUsername(String username);

}
