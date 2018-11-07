package mytest.sharedaspect.service;

import mytest.sharedaspect.model.ServiceTracker;
import mytest.sharedaspect.repository.TrackerRepositoryShared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TrackerServiceShared {

    @Autowired
    private TrackerRepositoryShared trackerRepositoryShared;

    public void logServiceTracker(ServiceTracker tracker) {
        this.trackerRepositoryShared.save(tracker);
    }
}
