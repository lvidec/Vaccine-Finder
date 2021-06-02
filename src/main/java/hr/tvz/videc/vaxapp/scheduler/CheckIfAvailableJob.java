package hr.tvz.videc.vaxapp.scheduler;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.service.VaccineService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckIfAvailableJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(CheckIfAvailableJob.class);
    private VaccineService vaccineService;

    @Autowired
    public CheckIfAvailableJob(VaccineService vaccineService){
        this.vaccineService = vaccineService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(CheckIfAvailableJob.class.getSimpleName());

        List<VaccineDTO> availableVaccines = vaccineService.findVaccineByAvailableDoses(0);
        log.info("This are currently available vaccines");
        log.info("---------------------------------------");
        availableVaccines.forEach(x -> log.info(x.getResearchName() + ' ' + x.getAvailableDoses()));
        log.info("---------------------------------------");

//        log.info(info.getCallbackData());
    }


}
