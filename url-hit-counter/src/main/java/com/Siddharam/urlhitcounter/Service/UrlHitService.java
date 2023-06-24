package com.Siddharam.urlhitcounter.Service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlHitService {


    HashMap<String, Integer> userHitCounts = new HashMap<>();

    public void incrementUserHitCount(String username){
        int userHitCount = userHitCounts.getOrDefault(username, 0);
        userHitCount++;
        userHitCounts.put(username, userHitCount);
    }

    public Integer getUserHitCounter(String username){
        incrementUserHitCount(username);
        return userHitCounts.get(username);
    }
}
