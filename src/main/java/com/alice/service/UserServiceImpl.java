package com.alice.service;

import com.alice.dao.RoleDAO;
import com.alice.dao.UserDAO;
import com.alice.domain.Dictionary;
import com.alice.domain.User;
import com.alice.domain.Word;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 030 30.03.17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    //сделать добавление ролей
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);
    }

    public void removeUser(String username) {
        userDAO.removeUser(username);
    }

    public void updateUser(User user) {
        User userForUpdate = userDAO.findByUsername(user.getUsername());
        if (userForUpdate != null) {
            userForUpdate.setUsername(user.getUsername());
            if (!user.getPassword().equals(userForUpdate.getPassword())) {
                //userForUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
                userForUpdate.setPassword(user.getPassword());
            }
            userForUpdate.setEmail(user.getEmail());
            userForUpdate.setTelephone(user.getTelephone());
            userForUpdate.setRoles(user.getRoles());
        }
    }

    public List<User> listUser() {
        return userDAO.listUser();
    }

    public List<Dictionary> dictionaryList() {
        User user = getCurrentUser();
        if (user != null) {
            Hibernate.initialize(user.getDictionaryList());
            return user.getDictionaryList();
        }
        return new ArrayList<Dictionary>();
    }

    public List<Word> wordList() {
        User user = getCurrentUser();
        if (user != null) {
            Hibernate.initialize(user.getWordList());
            return user.getWordList();
        }
        return new ArrayList<Word>();
    }


    public String getPrincipal() {
        String username = null;

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof UserDetails) {
            username = ((UserDetails) user).getUsername();
        } else {
            username = user.toString();
        }
        return username;
    }

    public User getCurrentUser() {
        return findByUsername(getPrincipal());
    }

    public boolean isUserUnique(Integer id, String name) {
        User user = findByUsername(name);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
