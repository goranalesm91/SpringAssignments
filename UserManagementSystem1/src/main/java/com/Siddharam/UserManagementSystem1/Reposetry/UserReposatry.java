package com.Siddharam.UserManagementSystem1.Reposetry;

import com.Siddharam.UserManagementSystem1.Modal.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReposatry {

    private ArrayList<User>userList=new ArrayList<>();
}
