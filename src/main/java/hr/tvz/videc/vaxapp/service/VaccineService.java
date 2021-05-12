package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;

import java.util.List;
import java.util.Optional;

public interface VaccineService {
    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    List<VaccineDTO> findVaccineByWarehouseDoses(long requestedWarehouseDosses);

    Optional<VaccineDTO> addVaccine(VaccineCommand vaccineCommand);

    Optional<VaccineDTO> updateVaccine(String vaxName, VaccineCommand vaccineCommand);

//    Optional<VaccineDTO> addSideEffect(SideEffect effect);

    List<VaccineDTO> findVaccinesByNumberOfWarehouseDoses(long warehouseDosesMin, long warehouseDosesMax);


    void deleteVaccine(String vaxName);

}
