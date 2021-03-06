package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository {
    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByAvailableDoses(long requestedAvailableDoses);

    Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand);

    Optional<Vaccine> updateVaccine(String researchName, VaccineCommand vaccineCommand);

    List<Vaccine> findVaccinesByNumberOfAvailableDoses(long availableDosesMin, long availableDosesMax);

    void deleteVaccine(String researchName);
}
