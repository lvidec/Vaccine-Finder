package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.model.Vaccine;
import hr.tvz.videc.vaxapp.model.VaccineDTO;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository {
    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByWarehouseDosses(long requestedWarehouseDosses);

    Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand);

    Optional<Vaccine> updateVaccine(String vaxName, VaccineCommand vaccineCommand);

    List<Vaccine> findVaccinesByNumberOfWarehouseDoses(long warehouseDosesMin, long warehouseDosesMax);


    void deleteVaccine(String vaxName);
}
