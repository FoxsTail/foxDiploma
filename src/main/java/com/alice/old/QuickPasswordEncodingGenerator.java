package com.alice.old;

import com.alice.dao.UserDAO;
import com.alice.dao.UserDAOImpl;
import com.alice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class QuickPasswordEncodingGenerator {

    /**
     * @param args
     */

    public static void main(String[] args) {
            String password = "111";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));

    }

}