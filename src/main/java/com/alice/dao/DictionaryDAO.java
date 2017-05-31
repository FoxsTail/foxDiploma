package com.alice.dao;

import com.alice.domain.Dictionary;

import java.util.List;

/**
 * Created by User on 013 13.05.17.
 */
public interface DictionaryDAO {
    Dictionary findById(Integer id);
    Dictionary findByDictionaryName(String dictionaryName);
    void saveDictionary(Dictionary dictionary);
    void removeDictionary(String dictionaryName);
    List<Dictionary> listDictionary();
}
