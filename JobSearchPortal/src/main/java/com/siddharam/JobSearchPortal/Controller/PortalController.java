package com.siddharam.JobSearchPortal.Controller;

import com.siddharam.JobSearchPortal.Model.Portal;
import com.siddharam.JobSearchPortal.Model.Type;
import com.siddharam.JobSearchPortal.Service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PortalController {
    @Autowired
    PortalService portalService;

    @PostMapping
    public String createJob(@Valid @RequestBody Portal portal) {
        return portalService.createJob(portal);
    }

    @GetMapping("/{id}")
    public String getJobById(@PathVariable Integer id) {
        return portalService.getJobById(id);
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Integer id, @Valid @RequestBody Portal job) {
        return portalService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Integer id) {
        return portalService.deleteJob(id);
    }


    @GetMapping("/search")
    public String searchJobs(@RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        if (title != null && description != null) {
            return portalService.searchJobsByTitleAndDescription(title, description);
        } else if (title != null) {
            return portalService.searchJobsByTitle(title);
        } else if (description != null) {
            return portalService.searchJobsByDescription(description);
        } else {
            return "Invalid search criteria";
        }
    }


    @GetMapping("/search/salary")
    public String searchJobsWithSalaryAbove(@RequestParam double salary) {
        return portalService.searchJobsWithSalaryAbove(salary);
    }
    @GetMapping("/search/company-name")
    public String searchJobsByCompanyName(@RequestParam String companyName) {
        return portalService.searchJobsByCompanyName(companyName);
    }

    @GetMapping("/search/employer-name")
    public String searchJobsByEmployerName(@RequestParam String employerName) {
        return portalService.searchJobsByEmployerName(employerName);
    }

    @GetMapping("/search/job-type")
    public String searchJobsByType(@RequestParam Type jobType) {
        return portalService.searchJobsByType(jobType);
    }


    @GetMapping("/search/location")
    public String searchJobsByLocation(@RequestParam String location) {
        return portalService.searchJobsByLocation(location);
    }


}
