package com.SocialMediaAppNew.SocialMediaAppNew;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")//path variable
    User findUserById(@PathVariable("id") int id){ //@PathVariable
        return userDaoService.findUserById(id);
    }

    @PostMapping("/users")
    public User createUser( @RequestBody User user){
        return userDaoService.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable("id") int id){
      return  userDaoService.deleteUser(id);
    }



}
