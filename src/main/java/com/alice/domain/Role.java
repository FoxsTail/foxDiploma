package com.alice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 030 30.04.17.
 */
@Entity
@Table(name = "role")
public class Role {

    private Integer id;
    private String role;
    private List<User> userList= new ArrayList<User>();

    //Constructors

    public Role() {
    }

    public Role(Integer id, String role) {
        this.role = role;
    }

    //Getters & Setters

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer userId) {
        this.id = userId;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(targetEntity = User.class, mappedBy = "roles")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        this.userList.add(user);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + role.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Role))
            return false;
        Role other = (Role) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
