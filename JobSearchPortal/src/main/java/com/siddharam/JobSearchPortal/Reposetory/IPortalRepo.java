package com.siddharam.JobSearchPortal.Reposetory;

import com.siddharam.JobSearchPortal.Model.Portal;
import com.siddharam.JobSearchPortal.Model.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPortalRepo extends CrudRepository<Portal,Integer> {
    List<Portal> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    List<Portal> findByTitleContainingIgnoreCase(String title);

    List<Portal> findByDescriptionContainingIgnoreCase(String description);

    List<Portal> findByJobType(Type jobType);
    //  query to search for job salary above a specific value
    @Query(value ="SELECT * FROM jobs WHERE salary > :salary", nativeQuery = true)
    List<Portal> findJobsWithSalaryAbove( double salary);

    @Query(value ="SELECT * FROM jobs WHERE company_name = :companyName", nativeQuery = true)
    List<Portal> findJobsByCompanyName(String companyName);

    @Query(value = "SELECT * FROM jobs WHERE employer_Name = :employerName" , nativeQuery = true)
    List<Portal> findJobsByEmployerName(String employerName);

    @Query(value = "SELECT * FROM jobs WHERE location = :location" , nativeQuery = true)
    List<Portal> findJobsByLocation(@Param("location") String location);
}
