package hr.tvz.videc.vaxapp;

import hr.tvz.videc.vaxapp.scheduler.CheckIfAvailableJob;
import hr.tvz.videc.vaxapp.scheduler.SchedulerService;
import hr.tvz.videc.vaxapp.scheduler.TimerInfo;
import hr.tvz.videc.vaxapp.scheduler.TimerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VaxappApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(VaxappApplication.class, args);
    }

    @Autowired
    SchedulerService schedulerService;

    @Override
    public void run(String... args) throws Exception {
        final TimerInfo info = new TimerInfo();
        info.setRunForever(true);
        info.setRepeatIntervalMs(10000);
        info.setInitialOffsetMs(1000);

        schedulerService.schedule(CheckIfAvailableJob.class, info);

        TimerUtil.triggerOnMidnightEveryWeekday(CheckIfAvailableJob.class);
    }
}
