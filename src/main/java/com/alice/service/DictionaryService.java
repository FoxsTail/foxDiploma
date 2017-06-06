package com.alice.service;

import com.alice.domain.Dictionary;
import com.alice.domain.Word;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
public interface DictionaryService {
    Dictionary findById(Integer id);

    Dictionary findByDictionaryName(String dictionaryName);

    void saveDictionary(Dictionary dictionary);

    void removeDictionary(String dictionaryName);

    void updateUser(Dictionary dictionary);

    List<Dictionary> listDictionary();

    List<Word> wordList(Dictionary dictionary);

    List<Dictionary> listPublicDictionary();
}
