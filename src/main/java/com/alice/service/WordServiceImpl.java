package com.alice.service;

import com.alice.dao.WordDAO;
import com.alice.domain.Dictionary;
import com.alice.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 014 14.05.17.
 */
@Service
@Transactional
public class WordServiceImpl implements WordService {

    @Autowired
    WordDAO wordDAO;

    public Word findById(Integer id) {
        return wordDAO.findById(id);
    }

    public Word findByWordName(String wordName) {
        return wordDAO.findByWordName(wordName);
    }

    public void saveWord(Word word, Dictionary dictionary) {
        wordDAO.saveWord(word, dictionary);
    }

    public void removeWord(String wordName) {
        wordDAO.removeWord(wordName);
    }

    public void updateUser(Word word) {

    }

    public List<Word> listWord() {
        return wordDAO.listWord();
    }
}
