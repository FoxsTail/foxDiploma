package com.alice.dao;

import com.alice.domain.Role;
import com.alice.domain.User;

import java.util.List;

/**
 * Created by User on 009 09.05.17.
 */
public interface RoleDAO {
    List<Role> roleList();
    Role findByRole(String role);
    Role findById(int id);
    void addRole(Role role);
}
