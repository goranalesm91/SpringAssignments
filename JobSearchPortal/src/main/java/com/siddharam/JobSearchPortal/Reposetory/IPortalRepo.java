package com.siddharam.JobSearchPortal.Reposetory;

import com.siddharam.JobSearchPortal.Model.Portal;
import org.springframework.data.repository.CrudRepository;

public interface IPortalRepo extends CrudRepository<Portal,Integer> {
    Iterable<Portal> findAllById(Integer id);
}
