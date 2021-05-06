package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.VaccineCommand;
//import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.model.Vaccine;
import hr.tvz.videc.vaxapp.model.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.VaccineRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineServ implements VaccineService, Serializable {

    private final VaccineRepository vaccineRepository;

    public VaccineServ(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
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
    public List<VaccineDTO> findVaccineByWarehouseDoses(long requestedWarehouseDosses) {
        return vaccineRepository.findVaccineByWarehouseDosses(requestedWarehouseDosses).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VaccineDTO> addVaccine(VaccineCommand vaccineCommand) {
        vaccineRepository.addVaccine(vaccineCommand);
        return Optional.of(mapVaccineToDTO(vaccineCommand));
    }

    @Override
    public Optional<VaccineDTO> updateVaccine(String vaxName, VaccineCommand vaccineCommand) {
        vaccineRepository.updateVaccine(vaxName, vaccineCommand);
        return Optional.of(mapVaccineToDTO(vaccineCommand));
    }

    @Override
    public List<VaccineDTO> findVaccinesByNumberOfWarehouseDoses(long warehouseDosesMin, long warehouseDosesMax) {
        return vaccineRepository.findVaccinesByNumberOfWarehouseDoses(warehouseDosesMin, warehouseDosesMax).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

//    @Override
//    public Optional<VaccineDTO> addSideEffect(SideEffect effect) {
//        return Optional.empty();
//    }

    @Override
    public void deleteVaccine(String vaxName) {
        vaccineRepository.deleteVaccine(vaxName);
    }

    private VaccineDTO mapVaccineToDTO(Vaccine vaccine){
        return new VaccineDTO(vaccine.getVaxName(), vaccine.getCompName(), vaccine.getNeededDoses());
    }

    private VaccineDTO mapVaccineToDTO(VaccineCommand vaccineCommand){
        return new VaccineDTO(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getNeededDoses());
    }

}