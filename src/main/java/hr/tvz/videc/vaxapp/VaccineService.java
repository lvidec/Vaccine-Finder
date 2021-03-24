package hr.tvz.videc.vaxapp;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface VaccineService {
    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);
}
