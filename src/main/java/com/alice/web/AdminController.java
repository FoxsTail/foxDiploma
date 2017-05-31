package com.alice.web;

import com.alice.domain.Role;
import com.alice.domain.User;
import com.alice.service.RoleService;
import com.alice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by User on 005 05.05.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/main")
    public String adminPage(ModelMap modelMap){
        modelMap.addAttribute("user", userService.getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("admin", true);
        return "newUser";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
        if (bindingResult.hasErrors() || (!userService.isUserUnique(user.getId(), user.getUsername()))){
            System.out.println("There are errors");
            return "newUser";
        }

        userService.saveUser(user);

        System.out.println("Name : "+user.getUsername());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Telephone: "+user.getTelephone());
        System.out.println("Checking UsrProfiles....");
        if(user.getRoles()!=null){
            for(Role role : user.getRoles()){
                System.out.println("Profile : "+ role.getRole());
            }
        }
        //modelMap.addAttribute("success", "Пользователь " + user.getUsername() + " успешно зарегистрирован!");
        modelMap.addAttribute("success", true);
        return "redirect:/admin/list";
    }

    @RequestMapping(value = { "/edit-user-{username}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String username, ModelMap model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("admin", true);
        return "newUser";
    }

    @RequestMapping(value = { "/edit-user-{username}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String username) {
        if (result.hasErrors()){
            return "newUser";
        }

        userService.updateUser(user);

        //model.addAttribute("success", "Пользователь " + user.getUsername() + " успешно обновлен!");
        model.addAttribute("success", true);
        return "redirect:/user/list";
    }

    @RequestMapping(value = { "/delete-user-{username}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username) {
        userService.removeUser(username);
        return "redirect:/admin/list";
    }

    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.roleList();
    }

}
