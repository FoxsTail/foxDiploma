package com.alice.service;

import com.alice.dao.RoleDAO;
import com.alice.domain.Role;
import com.alice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 010 10.05.17.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    public List<Role> roleList() {
        return roleDAO.roleList();
    }

    public Role findByRole(String role) {
        return roleDAO.findByRole(role);
    }

    public Role findById(int id) {
        return roleDAO.findById(id);
    }

    public void addRole(Role role) {
        roleDAO.addRole(role);
    }
}
