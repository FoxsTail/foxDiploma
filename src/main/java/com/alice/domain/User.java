package com.alice.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by User on 030 30.04.17.
 */
@Entity
@Table(name = "user")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private boolean enabled = true;
    private Date creation_date = new Date();
    private Set<Role> roles = new HashSet<Role>();
    private List<Dictionary> dictionaryList = new ArrayList<Dictionary>();
    private List<Word> wordList = new ArrayList<Word>();

    //Getters & Setters

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty
    //@Size(min = 3, max = 20, message = "Слишком короткое имя")
    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty
    //@Size(min=6, message = "Пароль должен быть не меньше 6ти символов.")
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$",
            message = "Заданный email не может существовать.")
    @Email(message = "Неверный email.")
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
  //  @Size(min=8, max= 15, message = "Телефонный номер должен соответствовать диапазону 8-15 символов.")
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "creation_date")
    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> userRoles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.addUser(this);
    }


    @ManyToMany(targetEntity = Dictionary.class, mappedBy = "userList")
    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    public void addDictionary(Dictionary dictionary){
        this.dictionaryList.add(dictionary);
    }



    @ManyToMany(targetEntity = Word.class, mappedBy = "userList")
    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
    public void addWord(Word word){
        this.wordList.add(word);
    }




  /*  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + username.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }*/


}
