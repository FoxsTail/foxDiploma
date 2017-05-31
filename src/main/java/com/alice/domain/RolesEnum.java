package com.alice.domain;

/**
 * Created by User on 009 09.05.17.
 */
public enum RolesEnum {
    USER("USER"),
    ADMIN("ADMIN");

    String userRole;

    private RolesEnum(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}
