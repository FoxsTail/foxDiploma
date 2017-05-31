package com.alice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 012 12.05.17.
 */
@Entity
@Table
public class Category {
    private Integer id;
    private String name;
    List<Dictionary> dictionaryList = new ArrayList<Dictionary>();


    //Constructors
    public Category() {
    }

    public Category(String name, List<Dictionary> dictionaryList) {
        this.id = id;
        this.name = name;
        this.dictionaryList = dictionaryList;
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

    @ManyToMany(targetEntity = Dictionary.class)
    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }
}
