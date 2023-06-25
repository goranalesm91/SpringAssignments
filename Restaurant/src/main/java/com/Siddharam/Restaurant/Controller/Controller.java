package com.Siddharam.Restaurant.Controller;

import com.Siddharam.Restaurant.Modal.Restorant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Restorant> restorantList;

    public  Controller(){
        restorantList=new ArrayList<>();
    }
    @GetMapping("GetById/{Id}")
    public Restorant getById(@PathVariable Integer Id){
        for(Restorant restorant : restorantList)
        {
            if(restorant.getRestaurantId().equals(Id))
            {
                return restorant;
            }
        }
        throw new IllegalStateException("id not found");
    }

    @GetMapping("getAll")
    public List<Restorant> getAllRestorant(){
        return restorantList;
    }
        @PostMapping("AddNewRestorant")
    public String addNewRestornt(@RequestBody Restorant restorant) {
        restorantList.add(restorant);
        return "sucsess";
    }

    @PutMapping(update/{specialty}/{id})
    public String updateSpecility(@PathVariable String specialty,Integer id)
    {
        for(Restorant restorant : getMyTodos())
        {
            if(myTodo.getTodoId().equals(todoId))
            {
                myTodo.setTodoDoneStatus(status);
                return "todo updated for todo ID:" + todoId;
            }
        }

        return "todo not found todo ID: " + todoId;
    }
}
