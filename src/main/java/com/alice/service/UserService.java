package com.alice.service;

import com.alice.domain.Dictionary;
import com.alice.domain.User;
import com.alice.domain.Word;

import java.util.List;

/**
 * Created by User on 030 30.03.17.
 */
public interface UserService {
    User findById(Integer id);
    User findByUsername(String username);
    void saveUser(User user);
    void removeUser(String username);
    void updateUser(User user);
    List<User> listUser();
    List<Dictionary> dictionaryList();
    List<Word> wordList();
    String getPrincipal();
    User getCurrentUser();
    boolean isUserUnique(Integer id, String username);
}
