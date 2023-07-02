package com.siddharam.JobSearchPortal.Service;

import com.siddharam.JobSearchPortal.Model.Portal;
import com.siddharam.JobSearchPortal.Reposetory.IPortalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortalService {
    @Autowired
    IPortalRepo iPortalRepo;
    public Iterable<Portal> getAllPortals() {
        return  iPortalRepo.findAll();
    }

    public String addPortal(Portal portal) {
        iPortalRepo.save(portal);
        return "added";
    }

    public Optional<Portal> getById(Integer id) {
        return iPortalRepo.findById(id);
    }
}
