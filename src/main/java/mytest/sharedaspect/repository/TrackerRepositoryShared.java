package mytest.sharedaspect.repository;

import mytest.sharedaspect.model.ServiceTracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepositoryShared extends CrudRepository<ServiceTracker, String> {
}
