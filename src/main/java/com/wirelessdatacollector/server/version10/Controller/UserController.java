package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.entity.User;
import com.wirelessdatacollector.server.version10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    // ---------------------------------
    // add new user
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addUser(@RequestBody User user){

        return userService.addUser(user);
    }

    // ---------------------------------
    // update user
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestBody User user){

        Integer userId = 0;

        if (user.getUserId() != 0){
            userId = user.getUserId();
        }
        return userService.updateUser(userId, user);
    }

    // ---------------------------------
    // get all users
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers(){

        return userService.getAllUsers();
    }

    // ---------------------------------
    // get a user
    // ---------------------------------
    @GetMapping(path = "/{roleId}")
    public @ResponseBody Optional<User> getUserById(@PathVariable Integer userId){

        return userService.getUserById(userId);
    }

    // ---------------------------------
    // delete user
    // ---------------------------------
    @DeleteMapping(path = "/delete/{userId}")
    public @ResponseBody String deleteUser(@PathVariable Integer userId){

        return userService.deleteUser(userId);
    }
}
