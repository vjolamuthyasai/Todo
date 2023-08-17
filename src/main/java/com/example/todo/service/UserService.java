package com.example.todo.service;

import com.example.todo.entity.User;
import com.example.todo.repositories.UserRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(User user){
        System.out.println("Service GET ****");

        return userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
    }

    public boolean getUserByUserName(String userName, String password){
        boolean userNameExists,passwordExists;
        try{
            userNameExists = userRepository.findTopByUserName(userName) != null ? true : false;
            System.out.println("UserName Present: "+ userNameExists);
            passwordExists = userRepository.findTopByPassword(password) != null ? true: false;
            System.out.println("Password Present: "+ passwordExists);
        }
        catch (NonUniqueResultException nre){
            return true;
        }
        return userNameExists && passwordExists;
    }

    public boolean findByUserName(String userName){
        boolean userNameExists;
        try{
            userNameExists = userRepository.findTopByUserName(userName) !=null ? true : false;
            System.out.println("UserName present(U): "+ userNameExists);
        }
        catch(NonUniqueResultException nre){

            return true;
        }

        return userNameExists;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
