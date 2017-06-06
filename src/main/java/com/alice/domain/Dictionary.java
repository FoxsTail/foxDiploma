package com.alice.domain;

import javax.persistence.*;
import java.util.*;

/**
 * Created by User on 012 12.05.17.
 */
@Entity
@Table
public class Dictionary {
    private Integer id;
    private String name;
    private boolean privacy;
    private Date last_review;
    private List<User> userList = new ArrayList<User>();
    private List<Word> wordList = new ArrayList<Word>();
  /*  private Set<Category> categorySet = new HashSet<Category>();

*/

    //Constructors

    public Dictionary() {
    }

    public Dictionary(String name, boolean privacy, Date last_review) {
        this.id = id;
        this.name = name;
        this.privacy = privacy;
        this.last_review = last_review;
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

    @Column(name = "privacy")
    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    @Column(name = "last_review")
    public Date getLast_review() {
        return last_review;
    }

    public void setLast_review(Date last_review) {
        this.last_review = last_review;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dictionary_user",
            joinColumns = @JoinColumn(name = "dictionary_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
        user.addDictionary(this);
    }


    @ManyToMany(targetEntity = Word.class, mappedBy = "dictionaryList")
    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void addWord(Word word){
        this.wordList.add(word);
    }


/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dictionary_category",
    joinColumns = @JoinColumn(name = "dictionary_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }
*/
}
