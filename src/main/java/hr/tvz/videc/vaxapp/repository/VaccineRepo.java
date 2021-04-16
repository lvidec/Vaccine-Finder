package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.model.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VaccineRepo implements VaccineRepository {

    private List<Vaccine> vaccineList = new LinkedList<>(Arrays.asList(
            new Vaccine("Pfizer-BioNTech", "Pfizer, Inc., and BioNTech", "mRNA", 2, 300, new SideEffect("Alergijska reakcija", "Moguća je pojava alergijske reakcije na određene sastojke cjepiva", 3)),
            new Vaccine("Moderna", "ModernaTX, Inc.", "mRNA", 2, 2000, new SideEffect("Rak pluca", "Moguća je pojava raka pluca na određene sastojke cjepiva", 1))
//            new Vaccine("praksa", "praksaComp", "mRNA", 1, 10000, sideEffect)
    ));

    @Override
    public List<Vaccine> findAll() {
        return vaccineList;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String vaxName) {
        return vaccineList.stream().filter(x -> Objects.equals(x.getVaxName(), vaxName)).findAny();
    }

    @Override
    public List<Vaccine> findVaccineByWarehouseDosses(long requestedWarehouseDosses) {
        return vaccineList.stream().filter(x -> x.getWarehouseDoses() > requestedWarehouseDosses).collect(Collectors.toList());
    }

    @Override
    public Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand) {
        Vaccine vaccine = new Vaccine(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getType(), vaccineCommand.getNeededDoses(), vaccineCommand.getWarehouseDoses(), vaccineCommand.getSideEffect());
        vaccineList.add(vaccine);
        return Optional.of(vaccine);
    }

    @Override
    public Optional<Vaccine> updateVaccine(String vaxName, VaccineCommand vaccineCommand) {
        Vaccine vaccineToAdd = new Vaccine(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getType(), vaccineCommand.getNeededDoses(), vaccineCommand.getWarehouseDoses(), vaccineCommand.getSideEffect());
        Vaccine vaccineToRemove = vaccineList.stream().filter( x -> x.getVaxName().equals(vaxName)).findFirst().orElseThrow();
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
