package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.entity.User;
import com.wirelessdatacollector.server.version10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ---------------------------------
    // add new user
    // ---------------------------------
    public String addUser(User user){

        try {
            userRepository.save(user);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update user
    // ---------------------------------
    public String updateUser(Integer userId, User user){

        if (userId == 0){
            return "Id not found";
        }

        try {
            user.setUserId(userId);
            userRepository.save(user);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all users
    // ---------------------------------
    public Iterable<User> getAllUsers(){

        return userRepository.findAll();
    }

    // ---------------------------------
    // get user by id
    // ---------------------------------
    public Optional<User> getUserById(Integer userId){

        return userRepository.findById(userId);
    }

    // ---------------------------------
    // delete a user
    // ---------------------------------
    public String deleteUser(Integer userId){

        try {
            userRepository.deleteById(userId);
            return "User deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}
