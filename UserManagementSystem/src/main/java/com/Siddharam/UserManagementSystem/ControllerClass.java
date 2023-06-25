package com.Siddharam.UserManagementSystem;

import com.Siddharam.UserManagementSystem.UserDetail.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerClass {
    private List<User> user;

    public ControllerClass() {
        user = new ArrayList<>();
    }
    @GetMapping("allUser")
    public List<User> allUserInfo(){
        return user;
    }
    @PostMapping("addUser")
    public String addUser(@RequestBody User user1){
        user.add(user1);
        return "sucsess";
}
    @GetMapping("user/{userId}")
    public ArrayList<User> markTodo(@PathVariable Integer userId)

    {
        ArrayList<User> al=new ArrayList<>();
        for(User myUser : user)
        {
            if(myUser.getUserID().equals(userId))
            {

               al.add(myUser);
                return al;
            }
        }
return al;

    }
    @DeleteMapping("Delete")
    public String removeUser(@RequestParam Integer userID)
    {
        for(User myUser : user)
        {
            if(myUser.getUserID().equals(userID))
            {
                user.remove(myUser);
                return "user removed for user_ID:" + userID;
            }
        }
        return "user :" + userID + " not deleted as it doesn't exist" ;

    }
@PutMapping("update/{userId}/{name}")
    public String UpdateName(@PathVariable Integer userId,@PathVariable String name ){
    for(User myUser : user)
    {
        if(myUser.getUserID().equals(userId))
        {
            myUser.setName(name);
            return "name is update for the id" + userId;
        }
    }
    return "user :" + userId + " it doesn't exist" ;

}
}
