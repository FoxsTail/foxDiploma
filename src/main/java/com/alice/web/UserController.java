package com.alice.web;


import com.alice.domain.User;
import com.alice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * Created by User on 004 04.04.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/profile")
    public String profilePage(ModelMap modelMap){
        return "profile";
    }

    @RequestMapping("/categories")
    public String categoriesPage(ModelMap modelMap){
        return "category";
    }

    @RequestMapping("/myDictionary")
    public String myDictionaryPage(ModelMap modelMap){
        return "myDictionary";
    }

    @RequestMapping("/training")
    public String trainingPage(ModelMap modelMap){
        return "training";
    }


    @RequestMapping("/index")
    public String listUser(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.listUser());

        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {

        userService.addUser(user);

        return "redirect:/user/index";
    }

    @RequestMapping("/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        userService.removeUser(userName);

        return "redirect:/index";
    }


}
