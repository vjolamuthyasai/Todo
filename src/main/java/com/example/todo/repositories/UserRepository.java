package com.example.todo.repositories;

import com.example.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndPassword(String userName, String password);

    User findTopByUserName(String userName);

    User findTopByPassword(String password);

}
