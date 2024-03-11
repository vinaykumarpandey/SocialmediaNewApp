package com.SocialMediaAppNew.SocialMediaAppNew;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserDaoService {

    //List<User> findAllusers()         Get All the users

    //User findUserById(int id)          Get User by Id

    //User createUser(User user)         Create a new User

    // Boolean deleteUser(int id)         Delete a specific user

    //  User  updateUser(int id, User user)    Update a user


   private static List<User> userList = new ArrayList<>();

   static{

       userList.add(new User(1, "Test1", LocalDate.now().minusYears(30)));
       userList.add(new User(2, "Test2", LocalDate.now().minusYears(25)));
       userList.add(new User(3, "Test3", LocalDate.now().minusYears(20)));

   }

    public List<User> findAllUsers(){
       return userList;
    }

   public User findUserById(int id){
       for(User user: userList){
           if(user.getId() == id)
               return user;
       }

       return null;
    }


}
