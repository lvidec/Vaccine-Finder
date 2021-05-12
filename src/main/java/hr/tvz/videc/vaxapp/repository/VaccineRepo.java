package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VaccineRepo implements VaccineRepository {

    private List<Vaccine> vaccineList = new LinkedList<>(Arrays.asList(
            new Vaccine("Pfizer-BioNTech", "Pfizer, Inc., and BioNTech", "mRNA", 2, 300),
            new Vaccine("Moderna", "ModernaTX, Inc.", "mRNA", 2, 2000)
    ));

    @Override
    public List<Vaccine> findAll() {
        return vaccineList;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String vaxName) {
        return vaccineList.stream().filter(x -> Objects.equals(x.getResearchName(), vaxName)).findAny();
    }

    @Override
    public List<Vaccine> findVaccineByAvailableDoses(long requestedAvailableDoses) {
        return vaccineList.stream().filter(x -> x.getAvailableDoses() > requestedAvailableDoses).collect(Collectors.toList());
    }

    @Override
    public Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand) {
        Vaccine vaccine = new Vaccine(vaccineCommand.getResearchName(), vaccineCommand.getManufacturerName(), vaccineCommand.getType(), vaccineCommand.getNumberOfShots(), vaccineCommand.getAvailableDoses());
        vaccineList.add(vaccine);
        return Optional.of(vaccine);
    }

    @Override
    public Optional<Vaccine> updateVaccine(String vaxName, VaccineCommand vaccineCommand) {
        Vaccine vaccineToAdd = new Vaccine(vaccineCommand.getResearchName(), vaccineCommand.getManufacturerName(), vaccineCommand.getType(), vaccineCommand.getNumberOfShots(), vaccineCommand.getAvailableDoses());
        Vaccine vaccineToRemove = vaccineList.stream().filter( x -> x.getResearchName().equals(vaxName)).findFirst().orElseThrow();
        int index = vaccineList.indexOf(vaccineToRemove);
        vaccineList.set(index, vaccineToAdd);
        System.out.println(vaccineList);
        return Optional.of(vaccineToAdd);
    }

    @Override
    public List<Vaccine> findVaccinesByNumberOfAvailableDoses(long availableDosesMin, long availableDosesMax) {
        return vaccineList.stream().filter(x -> x.getAvailableDoses() >= availableDosesMin && x.getAvailableDoses() <= availableDosesMax).collect(Collectors.toList());
    }

    @Override
    public void deleteVaccine(String vaxName) {
        vaccineList = vaccineList.stream().filter(x -> !x.getResearchName().equals(vaxName)).collect(Collectors.toList());
    }

}
