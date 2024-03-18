package com.SocialMediaAppNew.SocialMediaAppNew.service;

import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import com.SocialMediaAppNew.SocialMediaAppNew.exception.UserNotFoundException;
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

       throw new UserNotFoundException("User not found with the given id:" +id);
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

   public User  updateUser(int id, User newUser){


       /*
       1. Iterate on the list and get the existing user object with id - that we are passing in the method
       2. Create a new user object and update the new user with the name and date of birth that we are passing in the method
       3. Get the index of the existing user object from the userlist - by using indexOf method of ArrayList
       4. Update the new user in the userList
       5. return the new user


        */

       //TODO COMPLETE THE CODE BY RESOLVING NULL PARAMETER BUG
       User updateUser = new User();

       for(User existingUser: userList) {

           if (existingUser.getId() == id) {
               updateUser.setId(existingUser.getId());
               updateUser.setName(newUser.getName());
               updateUser.setBirthDate(newUser.getBirthDate());

               int index = userList.indexOf(existingUser);

               userList.set(index, updateUser);

           }
       }

           return updateUser;

       }

   public User updateUser(User newUser){

              /*
                 1. Iterate on the list and check the user id that is matching with the newUser's id
                 2. Get the existing object from the userlist with the id matching with newUser's id
                 3. replace the userlist object with newUser object at the matched id
              */
       User updateUser = new User();

       for(User existingUser: userList){
           if(existingUser.getId() == newUser.getId()){

               updateUser.setId(existingUser.getId());

               if(newUser.getName() != null) {
                   existingUser.setName(newUser.getName());
                   updateUser.setName(newUser.getName());
               } else {
                   updateUser.setName(existingUser.getName());
               }

               if(newUser.getBirthDate() != null){
                      existingUser.setBirthDate(newUser.getBirthDate());
                      updateUser.setBirthDate(newUser.getBirthDate());
               } else{
                   updateUser.setBirthDate(existingUser.getBirthDate());
               }
               int index = userList.indexOf(existingUser);
               userList.set(index, existingUser);
           }
       }

       return updateUser;



   }

   }
