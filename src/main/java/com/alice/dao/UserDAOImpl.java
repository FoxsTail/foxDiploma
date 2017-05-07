package com.alice.dao;

import com.alice.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 019 19.03.17.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .list();
    }

    public void removeUser(String username) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, username);

        if(user != null){
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username)
                .list();


        if(users.size() > 0){
            return users.get(0);
        }else
            return null;
    }

    //TODO: попробовать загружать юзера не листом а одной персоной
 /*  User user = (User) sessionFactory.getCurrentSession()
           .load(User.class, username);
   return user;
}*/
}
