package com.siddharam.JobSearchPortal.Controller;

import com.siddharam.JobSearchPortal.Model.Portal;
import com.siddharam.JobSearchPortal.Service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PortalController {
    @Autowired
    PortalService portalService;

    @GetMapping("portal")
    public Iterable<Portal> getAllPortals(){
        return portalService.getAllPortals();
    }
    @PostMapping("portal")
    public String AddPortals(@RequestBody Portal portal){
        return portalService.addPortal(portal);
    }
    @GetMapping("{id}")
    public Optional<Portal> getById(@PathVariable Integer id){
        return portalService.getById(id);
    }



}
