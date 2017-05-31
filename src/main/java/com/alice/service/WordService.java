package com.alice.service;

import com.alice.domain.Dictionary;
import com.alice.domain.Word;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
public interface WordService {
    Word findById(Integer id);

    Word findByWordName(String wordName);

    void saveWord(Word word, Dictionary dictionary);

    void removeWord(String wordName);

    void updateUser(Word word);

    List<Word> listWord();

}
