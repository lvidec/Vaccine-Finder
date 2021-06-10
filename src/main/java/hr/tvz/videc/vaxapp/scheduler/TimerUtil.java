package hr.tvz.videc.vaxapp.scheduler;

import org.quartz.*;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

import java.util.Date;

public class TimerUtil {

    public TimerUtil(){}

    public static JobDetail buildJobDetail(final Class jobClass, final TimerInfo info){
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static Trigger buildTrigger(final Class jobClass, final  TimerInfo info){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());

        if(info.isRunForever()){
            builder = builder.repeatForever();
        }else{
            builder = builder.withRepeatCount(info.getTotalFireCount() - 1);
        }

        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis() + info.getInitialOffsetMs()))
                .build();




    }

    public static void triggerOnMidnightEveryWeekday(final Class jobClass){

        CronTrigger trigger = newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(cronSchedule("0 0 0 * 6-7 ?"))
                .forJob(new JobKey("CheckIfAvailableJob"))
                .build();

    }


}
