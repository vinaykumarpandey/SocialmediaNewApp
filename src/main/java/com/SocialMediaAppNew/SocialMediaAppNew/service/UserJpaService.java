package com.SocialMediaAppNew.SocialMediaAppNew.service;

import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import com.SocialMediaAppNew.SocialMediaAppNew.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userJpaService")
public class UserJpaService implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public User updateUser(int id, User newUser) {
        return null;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }
}
