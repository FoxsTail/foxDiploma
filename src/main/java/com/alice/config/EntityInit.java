package com.alice.config;

import com.alice.domain.Role;
import com.alice.domain.RolesEnum;
import com.alice.domain.User;
import com.alice.service.RoleService;
import com.alice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



/**
 * Created by User on 014 14.05.17.
 */
@Component
public class EntityInit {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostConstruct
    public void init() {


       /* User lis = new User("lis", "$2a$10$OPnl8qeJe5oVfhTH.YL2Ueprz/fk0re1kzb0j5CuLm/vwp2ZdxdRy",
            "mimi@gi.com", "333444");
        User bob = new User("bob", "$2a$10$OPnl8qeJe5oVfhTH.YL2Ueprz/fk0re1kzb0j5CuLm/vwp2ZdxdRy",
            "boby@gi.com", "777666");

        Role user = new Role(1,RolesEnum.USER.getUserRole());
        Role admin = new Role(2, RolesEnum.ADMIN.getUserRole());

        System.out.println(user.toString());

        lis.setRoles(new HashSet<Role>());
        bob.setRoles(new HashSet<Role>());

        lis.addRole(admin);
        bob.addRole(user);

        user.setUsers(new ArrayList<User>());
        admin.setUsers(new ArrayList<User>());

        user.addUser(bob);
        admin.addUser(lis);

        userService.addUser(lis);
        userService.addUser(bob);

        roleService.addRole(user);
        roleService.addRole(admin);*/


    }
}