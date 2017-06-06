package com.alice.dao;

import com.alice.domain.Dictionary;
import com.alice.domain.User;
import com.alice.domain.Word;
import com.alice.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Repository
@Transactional
public class WordDAOImpl extends AbstractDAO<Integer, Word> implements WordDAO {

    @Autowired
    private DictionaryDAO dictionaryDAO;

    @Autowired
    private UserService userService;


    public Word findById(Integer id) {
        return getByKey(id);
    }

    public Word findByWordName(String wordName) {
        return getByName("from Word where name=?", wordName);
    }

    public void saveWord(Word word, Dictionary dictionary) {
        User user = userService.getCurrentUser();
        word.addUser(user);
        word.addDictionary(dictionary);
        persist(word);
    }

    public void removeWord(String wordName) {
        delete("from Word where name=?", wordName);
    }

    @SuppressWarnings("unchecked")
    public List<Word> listWord() {
        return getSession().createQuery("from Word").list();
    }
}
