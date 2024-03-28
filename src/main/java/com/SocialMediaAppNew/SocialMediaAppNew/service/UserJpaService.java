package com.SocialMediaAppNew.SocialMediaAppNew.service;

import com.SocialMediaAppNew.SocialMediaAppNew.exception.UserNotFoundException;
import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import com.SocialMediaAppNew.SocialMediaAppNew.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service("userJpaService")
@Service
@Primary
public class UserJpaService implements UserService{

    @Autowired
    UserRepository userRepository;

    Integer count = 7;

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

        Optional<User> getUserDetailsOptional = userRepository.findById(id);
        if(getUserDetailsOptional.isEmpty()){
            throw new UserNotFoundException("User not found with the given id:" +id);
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User updateUser(int id, User newUser) {
        return null;
    }

    @Override
    public Optional<User> findUserById(int id) {
       return userRepository.findById(id); //TODO Add user not found exception
    }
}
