package com.alice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 012 12.05.17.
 */
@Entity
@Table
public class Word {
    private Integer id;
    private String name;
    private String translation;
    private String sounding;
    private String mnemonic;
    private List<User> userList = new ArrayList<User>();
    private List<Dictionary> dictionaryList = new ArrayList<Dictionary>();

    //Constructors
    public Word() {
    }

    public Word(String name, String translation, String sounding,
                String mnemonic) {
        this.id = id;
        this.name = name;
        this.translation = translation;
        this.sounding = sounding;
        this.mnemonic = mnemonic;
    }

    //Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "translation")
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Column(name = "sounding")
    public String getSounding() {
        return sounding;
    }

    public void setSounding(String sounding) {
        this.sounding = sounding;
    }

    @Column(name = "mnemonic")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "word_dictionary",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name = "dictionary_id"))
    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    public void addDictionary(Dictionary dictionary){
        this.dictionaryList.add(dictionary);
        dictionary.addWord(this);
    }


     @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "word_user",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        this.userList.add(user);
        user.addWord(this);
    }
}
