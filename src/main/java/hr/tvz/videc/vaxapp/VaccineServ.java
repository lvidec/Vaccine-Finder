package hr.tvz.videc.vaxapp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
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

    private VaccineDTO mapVaccineToDTO(Vaccine vaccine){
        return new VaccineDTO(vaccine.getVaxName(), vaccine.getNeededDoses());
    }

}