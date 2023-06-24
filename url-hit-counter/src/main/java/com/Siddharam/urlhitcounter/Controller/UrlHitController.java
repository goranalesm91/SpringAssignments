package com.Siddharam.urlhitcounter.Controller;

import com.Siddharam.urlhitcounter.Service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
   // private String count;
    @Autowired
    private UrlHitService urlHitService;
 //   private List<User> user;
   HashMap<String,Integer> map=new HashMap<>();
   public UrlHitController(){
       map.put("visitor",0);
      // user=new ArrayList<User>();
   }

    @GetMapping("count")
    public HashMap<String,Integer> getHitCount() {
        int num=map.get("visitor");
        map.put("visitor",num+1);
        return map;
    }
    @GetMapping("{username}/count")
    public String getUserHitCount(@PathVariable String username){
        Integer temp = urlHitService.getUserHitCounter(username);
        String s = username + " , \n " + "  HitCount" + " : " + temp;
        return "{ Username" + " : "+s+" }";
    }
}
