package com.alice.dao;

import com.alice.domain.Role;
import com.alice.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 009 09.05.17.
 */
@Repository
@Transactional
public class RoleDAOImpl extends AbstractDAO<Integer, Role> implements RoleDAO {


    public Role findByRole(String role) {
        return getByName("from Role where role=?", role);
    }

    public Role findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Role> roleList() {
        return getSession().createQuery("from Role").list();
    }

    public void addRole(Role role) {
        persist(role);
    }

}
