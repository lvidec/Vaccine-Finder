package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VaccineRepo implements VaccineRepository {

    private List<Vaccine> vaccineList = new LinkedList<>(Arrays.asList(
            new Vaccine("Pfizer-BioNTech", "Pfizer, Inc., and BioNTech", "mRNA", 2, 300),
            new Vaccine("Moderna", "ModernaTX, Inc.", "mRNA", 2, 2000),
            new Vaccine("praksa", "praksaComp", "mRNA", 1, 10000)
    ));

    @Override
    public List<Vaccine> findAll() {
        return vaccineList;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return vaccineList.stream().filter(x -> Objects.equals(x.getVaxName(), researchName)).findAny();
    }

    @Override
    public List<Vaccine> findVaccineByWarehouseDosses(long requestedWarehouseDosses) {
        return vaccineList.stream().filter(x -> x.getWarehouseDoses() > requestedWarehouseDosses).collect(Collectors.toList());
    }

    @Override
    public Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand) {
        Vaccine vaccine = new Vaccine(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getType(), vaccineCommand.getNeededDoses(), vaccineCommand.getWarehouseDoses());
        vaccineList.add(vaccine);
        return Optional.of(vaccine);
    }

    @Override
    public Optional<Vaccine> updateVaccine(String compName, VaccineCommand vaccineCommand) {
        Vaccine vaccineToAdd = new Vaccine(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getType(), vaccineCommand.getNeededDoses(), vaccineCommand.getWarehouseDoses());
        Vaccine vaccineToRemove = vaccineList.stream().filter( x -> x.getCompName().equals(compName)).findFirst().orElseThrow();
        int index = vaccineList.indexOf(vaccineToRemove);
        vaccineList.set(index, vaccineToAdd);
        System.out.println(vaccineList);
        return Optional.of(vaccineToAdd);
    }

    @Override
    public void deleteVaccine(String vaxName) {
        vaccineList = vaccineList.stream().filter(x -> !x.getVaxName().equals(vaxName)).collect(Collectors.toList());
    }

}
