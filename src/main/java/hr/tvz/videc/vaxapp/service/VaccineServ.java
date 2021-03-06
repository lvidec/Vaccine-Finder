package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.VaccineRepository;
import hr.tvz.videc.vaxapp.scheduler.SchedulerService;
import hr.tvz.videc.vaxapp.scheduler.TimerInfo;
import hr.tvz.videc.vaxapp.scheduler.CheckIfAvailableJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineServ implements VaccineService, Serializable {

    private final VaccineRepository vaccineRepository;
    private final SchedulerService schedulerService;

    @Autowired
    public VaccineServ(VaccineRepository vaccineRepository, final SchedulerService schedulerService) {
        this.vaccineRepository = vaccineRepository;
        this.schedulerService = schedulerService;
    }

    @Override
    public void runJob(){
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        schedulerService.schedule(CheckIfAvailableJob.class, info);
    }


    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepository.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public VaccineDTO findVaccineByResearchName(String researchName) {
        return vaccineRepository.findVaccineByResearchName(researchName).map(this::mapVaccineToDTO).orElse(null);
    }

    @Override
    public List<VaccineDTO> findVaccineByAvailableDoses(long requestedAvailableDoses) {
        return vaccineRepository.findVaccineByAvailableDoses(requestedAvailableDoses).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VaccineDTO> addVaccine(VaccineCommand vaccineCommand) {
        vaccineRepository.addVaccine(vaccineCommand);
        return Optional.of(mapVaccineToDTO(vaccineCommand));
    }

    @Override
    public Optional<VaccineDTO> updateVaccine(String researchName, VaccineCommand vaccineCommand) {
        vaccineRepository.updateVaccine(researchName, vaccineCommand);
        return Optional.of(mapVaccineToDTO(vaccineCommand));
    }

    @Override
    public List<VaccineDTO> findVaccinesByNumberOfAvailableDoses(long availableDosesMin, long availableDosesMax) {
        return vaccineRepository.findVaccinesByNumberOfAvailableDoses(availableDosesMin, availableDosesMax).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

//    @Override
//    public Optional<VaccineDTO> addSideEffect(SideEffect effect) {
//        return Optional.empty();
//    }

    @Override
    public void deleteVaccine(String researchName) {
        vaccineRepository.deleteVaccine(researchName);
    }

    private VaccineDTO mapVaccineToDTO(Vaccine vaccine){
        return new VaccineDTO(vaccine.getResearchName(), vaccine.getManufacturerName(), vaccine.getType(), vaccine.getNumberOfShots(), vaccine.getAvailableDoses());
    }

    private VaccineDTO mapVaccineToDTO(VaccineCommand vaccineCommand){
        return new VaccineDTO(vaccineCommand.getResearchName(), vaccineCommand.getManufacturerName(), vaccineCommand.getType(), vaccineCommand.getNumberOfShots(), vaccineCommand.getAvailableDoses());
    }

}