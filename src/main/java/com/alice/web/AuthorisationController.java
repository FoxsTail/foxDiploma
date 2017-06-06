package com.alice.web;

import com.alice.domain.Role;
import com.alice.domain.User;
import com.alice.service.RoleService;
import com.alice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by User on 005 05.05.17.
 */
@Controller
public class AuthorisationController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(ModelMap modelMap) {
        modelMap.addAttribute("greetings", "Welcome to my app=)");
        return "welcome";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getPrincipal());
        return "error403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newRegistration(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("admin", false);
        return "newUser";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            System.out.println("There are errors");
            return "newUser";
        }
        userService.saveUser(user);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("success", true);
        return "welcome";
    }
}
