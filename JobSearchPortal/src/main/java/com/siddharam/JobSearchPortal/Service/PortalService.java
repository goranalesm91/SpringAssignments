package com.siddharam.JobSearchPortal.Service;

import com.siddharam.JobSearchPortal.Model.Portal;
import com.siddharam.JobSearchPortal.Model.Type;
import com.siddharam.JobSearchPortal.Reposetory.IPortalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortalService {
    private final IPortalRepo jobRepository;

    @Autowired
    public PortalService(IPortalRepo jobRepository) {
        this.jobRepository = jobRepository;
    }


    public String createJob(Portal job) {
        Portal savedJob = jobRepository.save(job);
        return "Job created with ID: " + savedJob.getId();
    }

    public String getJobById(Integer id) {
        Optional<Portal> jobOptional = jobRepository.findById(id);
        return jobOptional.map(job -> "Job found: " + job.toString()).orElse("Job not found");
    }

    public String updateJob(Integer id, Portal job) {
        Optional<Portal> existingJobOptional = jobRepository.findById(id);
        if (existingJobOptional.isPresent()) {
            Portal existingJob = existingJobOptional.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setLocation(job.getLocation());
            existingJob.setSalary(job.getSalary());
            existingJob.setCompanyEmail(job.getCompanyEmail());
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setEmployerName(job.getEmployerName());
            existingJob.setJobType(job.getJobType());
            existingJob.setAppliedDate(job.getAppliedDate());
            jobRepository.save(existingJob);
            return "Job updated with ID: " + existingJob.getId();
        } else {
            return "Job not found";
        }
    }

    public String deleteJob(Integer id) {
        jobRepository.deleteById(id);
        return "Job with ID " + id + " deleted";
    }
    public String searchJobsByTitleAndDescription(String title, String description) {
        List<Portal> jobs = jobRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title, description);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByTitle(String title) {
        List<Portal> jobs = jobRepository.findByTitleContainingIgnoreCase(title);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByDescription(String description) {
        List<Portal> jobs = jobRepository.findByDescriptionContainingIgnoreCase(description);
        return "Search result: " + jobs.toString();
    }



    public String searchJobsWithSalaryAbove(double salary) {
        List<Portal> jobs = jobRepository.findJobsWithSalaryAbove(salary);
        return "Search result: " + jobs.toString();}




    public String searchJobsByCompanyName(String companyName) {
        List<Portal> jobs = jobRepository.findJobsByCompanyName(companyName);
        return "Search result: " + jobs.toString();
    }
    public String searchJobsByEmployerName(String employerName) {
        List<Portal> jobs = jobRepository.findJobsByEmployerName(employerName);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByType(Type jobType) {
        List<Portal> jobs = jobRepository.findByJobType(jobType);
        return "Search result: " + jobs.toString();
    }


    public String searchJobsByLocation(String location) {
        List<Portal> jobs = jobRepository.findJobsByLocation(location);
        return "Search result: " + jobs.toString();
    }

}
