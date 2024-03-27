package com.SocialMediaAppNew.SocialMediaAppNew.service;

import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public List<User> findAllUsers();
    public User createUser(User user);
    public boolean deleteUser(int id);

    public User  updateUser(int id, User newUser);

    public User findUserById(int id);



}
