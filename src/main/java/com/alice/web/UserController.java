package com.alice.web;


import com.alice.domain.Dictionary;
import com.alice.domain.User;
import com.alice.domain.Word;
import com.alice.service.DictionaryService;
import com.alice.service.UserService;

import com.alice.service.WordService;
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
import javax.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 004 04.04.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private WordService wordService;

    @RequestMapping("/main")
    public String mainPage(ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getPrincipal());
        modelMap.addAttribute("words", userService.wordList());
        return "main";
    }

    @RequestMapping("/profile")
    public String profilePage(ModelMap modelMap) {
        User user = userService.getCurrentUser();
        modelMap.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = { "/profile-edit-{username}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String username) {
        if (result.hasErrors()){
            return "profile";
        }

        userService.updateUser(user);

        model.addAttribute("success", true);
        return "redirect:/user/profile";
    }


    @RequestMapping("/training")
    public String trainingPage(ModelMap modelMap) {
        return "training";
    }

    //-----------------Word--------------------------//
    @RequestMapping(value = {"/{dictionaryName}"}, method = RequestMethod.GET)
    public String dictionaryPage(@PathVariable String dictionaryName, ModelMap modelMap){
        Dictionary dictionary = dictionaryService.findByDictionaryName(dictionaryName);
        modelMap.addAttribute("dictionary", dictionary);
        modelMap.addAttribute("words", dictionary.getWordList());
        return "dictionaryPage";
    }

    @RequestMapping(value = "/{dictionaryName}/addWord", method = RequestMethod.GET)
    public String addWord(@PathVariable String dictionaryName, ModelMap modelMap) {
        modelMap.addAttribute("word", new Word());
        return "addWord";
    }

    @RequestMapping(value = "/{dictionaryName}/addWord", method = RequestMethod.POST)
    public String addDictionary(@PathVariable String dictionaryName, @ModelAttribute("word") Word word, BindingResult bindingResult, ModelMap modelMap) {
        Dictionary dictionary = dictionaryService.findByDictionaryName(dictionaryName);
        wordService.saveWord(word, dictionary);
        modelMap.addAttribute("dictionaryName", dictionaryName);
        return "redirect:/user/{dictionaryName}";
    }



    //-----------------Dictionary--------------------//

    @RequestMapping("/foxsDan")
    public String categoriesPage(ModelMap modelMap) {
        modelMap.addAttribute("dictionariesPublic", dictionaryService.listPublicDictionary());
        return "foxsDan";
    }

    @RequestMapping(value = "/myDictionary", method = RequestMethod.GET)
    public String myDictionaryPage(ModelMap modelMap) {
        modelMap.addAttribute("dictionary", new Dictionary());
        return "myDictionary";
    }

    @RequestMapping(value = "/addDictionary", method = RequestMethod.POST)
    public String addDictionary(@ModelAttribute("dictionary") Dictionary dictionary, BindingResult bindingResult, ModelMap modelMap) {
        dictionary.setPrivacy(true);
        dictionaryService.saveDictionary(dictionary);
        return "redirect:/user/myDictionary";
    }

    @RequestMapping(value = { "/delete-dictionary-{dictionaryName}" }, method = RequestMethod.GET)
    public String deleteDictionary(@PathVariable String dictionaryName) {
        dictionaryService.removeDictionary(dictionaryName);
        return "redirect:/user/myDictionary";
    }

    @ModelAttribute("dictionaries")
    public List<Dictionary> dictionaryList() {
        return userService.dictionaryList();
    }





    //-------------//
    @RequestMapping("/index")
    public String listUser(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.listUser());

        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {

        userService.saveUser(user);

        return "redirect:/user/index";
    }

    @RequestMapping("/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        userService.removeUser(userName);

        return "redirect:/index";
    }



}
