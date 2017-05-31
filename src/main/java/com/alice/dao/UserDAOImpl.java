package com.alice.dao;

import com.alice.domain.Role;
import com.alice.domain.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 019 19.03.17.
 */
@Repository
@Transactional
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO {

    @Autowired
    private RoleDAO roleDAO;

    public User findById(Integer id) {

        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        List<User> userList = getSession().createQuery("from User where username=?").setParameter(0, username).list();
        try {
            return userList.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
//перенести на контроллер, а то много юзверей
    public void saveUser(User user) {
        Role role = roleDAO.findByRole("USER");
        user.addRole(role);
        persist(user);
    }

    public void removeUser(String username) {
        delete("from User where username=?", username);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return getSession().createQuery("from User")
                .list();
    }

}
