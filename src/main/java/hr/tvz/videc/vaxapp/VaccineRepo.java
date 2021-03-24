package hr.tvz.videc.vaxapp;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VaccineRepo implements VaccineRepository {

    private final List<Vaccine> vaccineList = Arrays.asList(
            new Vaccine("Pfizer-BioNTech", "Pfizer, Inc., and BioNTech", "RNA", 2, 300),
            new Vaccine("Moderna", "ModernaTX, Inc.", "RNA", 2, 2000)
    );

    @Override
    public List<Vaccine> findAll() {
        return vaccineList;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return vaccineList.stream().filter(x -> Objects.equals(x.getVaxName(), researchName)).findAny();
    }
}
