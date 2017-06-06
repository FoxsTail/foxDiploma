package com.alice.service;

import com.alice.domain.Role;
import com.alice.domain.User;

import java.util.List;

/**
 * Created by User on 010 10.05.17.
 */
public interface RoleService {
    List<Role> roleList();
    Role findByRole(String role);
    Role findById(int id);
    void addRole(Role role);
}
