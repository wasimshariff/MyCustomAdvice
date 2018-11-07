package mytest.sharedaspect.aspect;

import mytest.sharedaspect.model.ServiceTracker;
import mytest.sharedaspect.service.TrackerServiceShared;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Configuration //needed if parent using componentScan
@Component
@Aspect
public class MySharedAspect {

    @Autowired
    private TrackerServiceShared trackerServiceShared;

   /* @Async
    @Before("execution(* com.example.postgres.controller..*(..))")
    public void logMethod(JoinPoint jp) throws InterruptedException {
        System.out.println("======Inside my shared aspect====");
        System.out.println(jp.getThis());
        System.out.println(jp.getTarget());
        System.out.println(jp.toString());

    }*/

    @Async
    @Before(value = "@within(mytest.sharedaspect.annotation.ServiceTrackerAnnotation)")
    public void logMethod(JoinPoint jp) throws InterruptedException {
        System.out.println("=============MySharedAspect Before Advice=================");
        ServiceTracker tracker = new ServiceTracker();
        tracker.setId(UUID.randomUUID().toString());
        tracker.setMethod(jp.getSignature().toString());
        trackerServiceShared.logServiceTracker(tracker);

    }

    @EventListener
    public void started(ContextRefreshedEvent event) {
        System.err.println("Started MySharedAspect" + ": " + event);
    }

}
