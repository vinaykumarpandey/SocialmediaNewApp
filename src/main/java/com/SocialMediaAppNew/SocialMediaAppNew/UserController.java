package com.SocialMediaAppNew.SocialMediaAppNew;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/message")
    public String getMessage(){
        String cityName = "Bangalore";
        return "some message " + cityName;
    }

    @GetMapping("/users")
    List<User> findAllUsers(){

       return userDaoService.findAllUsers();
    }

    @GetMapping("/users/1")
    User findUserById(){
        return userDaoService.findUserById(1);
    }



}
