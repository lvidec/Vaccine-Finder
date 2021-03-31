package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.VaccineDTO;

import java.util.List;
import java.util.Optional;

public interface VaccineService {
    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    List<VaccineDTO> findVaccineByWarehouseDoses(long requestedWarehouseDosses);

    Optional<VaccineDTO> addVaccine(VaccineCommand vaccineCommand);

    Optional<VaccineDTO> updateVaccine(String compName, VaccineCommand vaccineCommand);

    void deleteVaccine(String vaxName);
}
