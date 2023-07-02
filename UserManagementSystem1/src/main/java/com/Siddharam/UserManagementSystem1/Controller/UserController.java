package com.Siddharam.UserManagementSystem1.Controller;

import com.Siddharam.UserManagementSystem1.Modal.User;
import com.Siddharam.UserManagementSystem1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservices;


    @PostMapping
    public String addUser(@Valid @RequestBody User user ) {

        return userservices.saveUser(user);



    }
    @GetMapping

    public ArrayList<User> getAllUser() {
        return userservices.retriveAllUsers();
    }

    @GetMapping("{userid}")
    public User getUserById(@Valid @PathVariable("userid") String userid){

        return userservices.findUserById(userid);
    }

    @PutMapping("{userid}")
    public String updateUserInfo(@Valid @PathVariable("userid") String userid, @Valid @RequestBody User user) {

        return userservices.updateUserInfo(userid,user);
    }

    @DeleteMapping("{userid}")

    public String deleteUserInfo(@Valid @PathVariable("userid")String userid) {

        return userservices.removeUserById(userid);
    }

}
