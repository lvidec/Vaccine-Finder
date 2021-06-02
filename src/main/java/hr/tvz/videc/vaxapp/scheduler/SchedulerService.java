package hr.tvz.videc.vaxapp.scheduler;

import hr.tvz.videc.vaxapp.scheduler.TimerInfo;
import hr.tvz.videc.vaxapp.scheduler.CheckIfAvailableJob;
import hr.tvz.videc.vaxapp.scheduler.TimerUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(CheckIfAvailableJob.class);


    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    @PostConstruct
    public void init(){
        try{
            scheduler.start();
        }catch (SchedulerException e){
            log.error(e.getMessage(), e);
        }
    }

    public void schedule(final Class jobClass, final TimerInfo info){
        final JobDetail jobDetail = TimerUtil.buildJobDetail(jobClass, info);
        final Trigger trigger = TimerUtil.buildTrigger(jobClass, info);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

//    public void updateTimer(final String timerId, final TimerInfo info){
//        try{
//            final JobDetail jobDetail = scheduler.getJobDetail(new JobKey(timerId));
//
//            if(jobDetail == null){
//                log.error("Failed to find timer with ID '{}'", timerId);
//                return;
//            }
//
//            jobDetail.getJobDataMap().put(timerId, info);
//
//            scheduler.addJob(jobDetail, true, true);
//
//        } catch (SchedulerException e) {
//            log.error(e.getMessage(), e);
//        }
//
//    }
//
//    public Boolean deleteTimer(final String timerId){
//        try{
//            return scheduler.deleteJob(new JobKey(timerId));
//
//        } catch (SchedulerException e) {
//            log.error(e.getMessage(), e);
//            return false;
//        }
//
//    }


    @PreDestroy
    public void preDestroy(){
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }


}
