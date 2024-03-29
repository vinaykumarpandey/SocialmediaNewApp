package com.SocialMediaAppNew.SocialMediaAppNew.repo;

import com.SocialMediaAppNew.SocialMediaAppNew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

  public User save(User user);

}
