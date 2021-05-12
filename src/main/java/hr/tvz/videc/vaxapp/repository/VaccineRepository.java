package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;

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
