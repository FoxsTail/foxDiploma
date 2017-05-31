package com.alice.old.somestuff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by User on 019 19.05.17.
 */
@Controller
public class StuffController {

    @RequestMapping(value = "/stuff", method = RequestMethod.GET)
    public String getStuff() {
        return "stuff";
    }

    @RequestMapping(value = "/stuff", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String checkStuff(@RequestParam("login") String login) {
        System.out.println(login);
        if (login.equals("admin")) {
            return "0";
        }
        return "1";
    }


}
