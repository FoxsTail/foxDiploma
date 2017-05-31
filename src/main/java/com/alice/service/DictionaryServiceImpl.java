package com.alice.service;

import com.alice.dao.DictionaryDAO;
import com.alice.dao.UserDAO;
import com.alice.domain.Dictionary;
import com.alice.domain.Word;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryDAO dictionaryDAO;

    @Autowired
    private UserService userService;

    public Dictionary findById(Integer id) {
        return dictionaryDAO.findById(id);
    }

    public Dictionary findByDictionaryName(String dictionaryName) {
        return dictionaryDAO.findByDictionaryName(dictionaryName);
    }

    public void saveDictionary(Dictionary dictionary) {
        dictionaryDAO.saveDictionary(dictionary);
    }

    public void removeDictionary(String dictionaryName) {
        dictionaryDAO.removeDictionary(dictionaryName);
    }

    public void updateUser(Dictionary dictionary) {

    }

    public List<Dictionary> listDictionary() {
        return dictionaryDAO.listDictionary();
    }

    public List<Word> wordList(Dictionary dictionary) {
            if (dictionary != null) {
                try {
                    Hibernate.initialize(dictionary.getWordList());
                    return dictionary.getWordList();
                }catch (RuntimeException e){
                    return new ArrayList<Word>();
                }
            }
            return new ArrayList<Word>();
    }

    public List<Dictionary> listPublicDictionary() {
        List<Dictionary> publicList = new ArrayList<Dictionary>();

        for(Dictionary dictionary: listDictionary()){
            if(!dictionary.isPrivacy()){
                publicList.add(dictionary);
            }
        }
        return publicList;
    }
}
