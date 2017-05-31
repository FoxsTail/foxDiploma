package com.alice.config;

import com.alice.domain.Role;
import com.alice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by User on 011 11.05.17.
 */
@Component
public class RoleToUserRoleConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;

    //переводит представление роли из строки в реальную роль в базе данных
    public Role convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        Role userRole = roleService.findById(id);
        System.out.println("Profile : "+userRole);
        return userRole;
    }
}
