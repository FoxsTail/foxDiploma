package com.alice.dao;

import com.alice.domain.User;

import java.util.List;

/**
 * Created by User on 019 19.03.17.
 */
public interface UserDAO {

    User findById(Integer id);
    User findByUsername(String username);
    void saveUser(User user);
    void removeUser(String username);
    List<User> listUser();

}
