package com.SocialMediaAppNew.SocialMediaAppNew;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserDaoService {

    //List<User> findAllusers()         Get All the users -Done

    //User findUserById(int id)          Get User by Id -Done

    //User createUser(User user)         Create a new User - Done

    // Boolean deleteUser(int id)         Delete a specific user - Done

    //  User  updateUser(int id, User user)    Update a user


   private static List<User> userList = new ArrayList<>();

   private static int count;

   static{

       userList.add(new User(++count, "Test1", LocalDate.now().minusYears(30)));
       userList.add(new User(++count, "Test2", LocalDate.now().minusYears(25)));
       userList.add(new User(++count, "Test3", LocalDate.now().minusYears(20)));

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

   public User createUser(User user){

       user.setId(++count);
       userList.add(user);
       return user;

   }

   public boolean deleteUser(int id){
       for(User user: userList){
           if(user.getId() == id) {
               userList.remove(user);
               return true;
           }

       }

       return false;
   }


}
