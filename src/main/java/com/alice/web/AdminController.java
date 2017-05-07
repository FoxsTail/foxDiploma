package com.alice.web;

import com.alice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 005 05.05.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String adminPage(ModelMap modelMap){
        modelMap.addAttribute("user", userService.getPrincipal());
        return "admin";
    }


}
