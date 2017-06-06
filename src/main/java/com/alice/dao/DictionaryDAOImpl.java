package com.alice.dao;

import com.alice.domain.Dictionary;
import com.alice.domain.User;
import com.alice.domain.Word;
import com.alice.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Repository
@Transactional
public class DictionaryDAOImpl extends AbstractDAO<Integer, Dictionary> implements DictionaryDAO {
    @Autowired
    private UserService userService;

    public Dictionary findById(Integer id) {
        return getByKey(id);
    }

    public Dictionary findByDictionaryName(String dictionaryName) {
        Dictionary dictionary = getByName("from Dictionary where name=?", dictionaryName);
        if (dictionary != null) {
                Hibernate.initialize(dictionary.getWordList());
        }
        return dictionary;
    }

    public void saveDictionary(Dictionary dictionary) {
        User user = userService.getCurrentUser();
        dictionary.addUser(user);
        persist(dictionary);
    }

    public void removeDictionary(String dictionaryName) {
        delete("from Dictionary where name=?", dictionaryName);
    }

    @SuppressWarnings("unchecked")
    public List<Dictionary> listDictionary() {
        return getSession().createQuery("from Dictionary").list();
    }

}
