package com.SocialMediaAppNew.SocialMediaAppNew.controller;


import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import com.SocialMediaAppNew.SocialMediaAppNew.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
   // @Qualifier("userDaoService")
    UserService userService;

    @GetMapping("/message")
    public String getMessage(){
        String cityName = "Bangalore";
        return "some message " + cityName;
    }

    @GetMapping("/users")
    List<User> findAllUsers(){

       return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")//path variable
    Optional<User> findUserById(@PathVariable("id") int id){ //@PathVariable
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){

        User savedUser = userService.createUser(user);
        //URI uri = URI.create("http://localhost:8080/users/" +savedUser.getId()); // http://localhost:8080/users/4
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()  //http://localhost:8080/users
                                             .path("/{id}")   //http://localhost:8080/users/{id}
                                             .buildAndExpand(savedUser.getId())  //http://localhost:8080/users/4
                                             .toUri();
       return new ResponseEntity<>(uri, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable("id") int id){
      return  userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

/*    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }*/



}
