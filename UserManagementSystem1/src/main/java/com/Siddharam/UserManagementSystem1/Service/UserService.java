package com.Siddharam.UserManagementSystem1.Service;

import com.Siddharam.UserManagementSystem1.Modal.User;
import com.Siddharam.UserManagementSystem1.Reposetry.UserReposatry;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.ArrayList;

public class UserService {
    @Autowired
    private UserReposatry userrepository;

    public String saveUser(User user) {

        ArrayList<User> current=userrepository.getUserList();

        current.add(user);

        userrepository.setUserList(current);

        return "Sucessfully added";
    }

    public ArrayList<User> retriveAllUsers() {

        ArrayList<User>current=userrepository.getUserList();
        return current;
    }

    public User findUserById(@Valid String userid) {
        ArrayList<User>current=userrepository.getUserList();

        for(User user:current) {

            if(user.getUserId().equals(userid)) {

                return user;
            }

        }return null;


    }

    public String updateUserInfo(@Valid String userid,User user) {
        ArrayList<User>current=userrepository.getUserList();

        for(User u1:current) {

            if(u1.getUserId().equals(userid)) {

                u1.setDate(user.getDate());
                u1.setDateOfBirth(user.getDateOfBirth());
                u1.setEmail(user.getEmail());
                u1.setPhoneNumber(user.getPhoneNumber());
                u1.setUserId(user.getUserId());
                u1.setUserName(user.getUserName());
                u1.setTime(user.getTime());

                userrepository.setUserList(current);

                return "sucessfully updated";}


        }return "update not happend check the userid again";}

    public String removeUserById(@Valid String userid) {

        ArrayList<User>current=userrepository.getUserList();


        for(User user:current) {

            if(user.getUserId().equals(userid)) {

                current.remove(user);
                userrepository.setUserList(current);
                return "Sucessfully removed ";
            }}

        return "Error Check the userid again";

    }








}
