package hr.tvz.videc.vaxapp.repo;

import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.repository.VaccineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class VaccineRepositoryTest {


    @Autowired
    VaccineRepository vaccineRepository;

    @Test
    public void testFindAll(){
        List<Vaccine> vaccineList = vaccineRepository.findAll();
        Assertions.assertNotNull(vaccineList);
        Assertions.assertEquals(vaccineList.size(), 3);
    }

    @Test
    public void testFindVaccineByResearchName(){
        Optional<Vaccine> vaccine = vaccineRepository.findVaccineByResearchName("Pfizer-BioNTech");
        Assertions.assertNotNull(vaccine);
        Assertions.assertEquals(vaccine.get().getManufacturerName(), "Pfizer, Inc., and BioNTech");
    }

    @Test
    public void testFindVaccineByAvailableDoses(){
        List<Vaccine> vaccineList = vaccineRepository.findVaccineByAvailableDoses(300);
        Assertions.assertNotNull(vaccineList);
        Assertions.assertEquals(vaccineList.size(), 1);
    }

    @Test
    public void testFindVaccinesByNumberOfAvailableDoses(){
        List<Vaccine> vaccineList = vaccineRepository.findVaccinesByNumberOfAvailableDoses(301L, 100000L);
        Assertions.assertNotNull(vaccineList);
        Assertions.assertEquals(vaccineList.size(), 2);
    }

    @Test
    @DirtiesContext
    public void testAddVaccine(){
        vaccineRepository.addVaccine(new VaccineCommand("mockResearchName", "mockManufacturerName", "mockMrna", 2, 10));

        List<Vaccine> vaccineList = vaccineRepository.findAll();
        Assertions.assertNotNull(vaccineList);
        Assertions.assertEquals(vaccineList.size(), 4);
    }

//    @Test
//    @DirtiesContext
//    public void testUpdateVaccine(){
//        vaccineRepository.updateVaccine("Pfizer-BioNTech", new VaccineCommand("mockResearchName", "mockManufacturerName", "mockMrna", 2, 10));
//
//        Optional<Vaccine> vaccine = vaccineRepository.findVaccineByResearchName("mockResearchName");
//        Assertions.assertNotNull(vaccine);
//        Assertions.assertEquals(vaccine.get().getResearchName(), "mockResearchName");
//    }

//    @Transactional
//    @DirtiesContext
//    @Test
//    public void testDeleteVaccine(){
//        vaccineRepository.deleteVaccine("Moderna");
//
//        Optional<Vaccine> vaccine = vaccineRepository.findVaccineByResearchName("Moderna");
//        Assertions.assertFalse(vaccine.isPresent());
//    }


}
