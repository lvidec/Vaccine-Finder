package hr.tvz.videc.vaxapp.serv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.VaccineRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import hr.tvz.videc.vaxapp.service.VaccineServ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VaccineServ.class})
@ExtendWith(SpringExtension.class)
public class VaccineServiceTest {
    @MockBean
    private VaccineRepository vaccineRepository;

    @Autowired
    private VaccineServ vaccineServ;

    @Test
    public void testFindAll() {
        when(this.vaccineRepository.findAll()).thenReturn(new ArrayList<Vaccine>());
        assertTrue(this.vaccineServ.findAll().isEmpty());
        verify(this.vaccineRepository).findAll();
    }

    @Test
    public void testFindAll2() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findAll()).thenReturn(vaccineList);
        List<VaccineDTO> actualFindAllResult = this.vaccineServ.findAll();
        assertEquals(1, actualFindAllResult.size());
        VaccineDTO getResult = actualFindAllResult.get(0);
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        assertEquals("Type", getResult.getType());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        verify(this.vaccineRepository).findAll();
    }

    @Test
    public void testFindAll3() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        Vaccine vaccine1 = new Vaccine();
        vaccine1.setNumberOfShots(10);
        vaccine1.setResearchName("Research Name");
        vaccine1.setId(123L);
        vaccine1.setManufacturerName("Manufacturer Name");
        vaccine1.setAvailableDoses(0L);
        vaccine1.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine1);
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findAll()).thenReturn(vaccineList);
        List<VaccineDTO> actualFindAllResult = this.vaccineServ.findAll();
        assertEquals(2, actualFindAllResult.size());
        VaccineDTO getResult = actualFindAllResult.get(0);
        assertEquals("Type", getResult.getType());
        VaccineDTO getResult1 = actualFindAllResult.get(1);
        assertEquals("Type", getResult1.getType());
        assertEquals("Research Name", getResult1.getResearchName());
        assertEquals(10, getResult1.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult1.getManufacturerName());
        assertEquals(0L, getResult1.getAvailableDoses().longValue());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        verify(this.vaccineRepository).findAll();
    }

    @Test
    public void testFindVaccineByResearchName() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(1L);
        vaccine.setType("Type");
        Optional<Vaccine> ofResult = Optional.<Vaccine>of(vaccine);
        when(this.vaccineRepository.findVaccineByResearchName(anyString())).thenReturn(ofResult);
        VaccineDTO actualFindVaccineByResearchNameResult = this.vaccineServ.findVaccineByResearchName("Research Name");
        assertEquals(1L, actualFindVaccineByResearchNameResult.getAvailableDoses().longValue());
        assertEquals("Type", actualFindVaccineByResearchNameResult.getType());
        assertEquals("Research Name", actualFindVaccineByResearchNameResult.getResearchName());
        assertEquals(10, actualFindVaccineByResearchNameResult.getNumberOfShots());
        assertEquals("Manufacturer Name", actualFindVaccineByResearchNameResult.getManufacturerName());
        verify(this.vaccineRepository).findVaccineByResearchName(anyString());
    }

    @Test
    public void testFindVaccineByResearchName2() {
        when(this.vaccineRepository.findVaccineByResearchName(anyString())).thenReturn(Optional.<Vaccine>empty());
        assertNull(this.vaccineServ.findVaccineByResearchName("Research Name"));
        verify(this.vaccineRepository).findVaccineByResearchName(anyString());
    }

    @Test
    public void testFindVaccineByAvailableDoses() {
        when(this.vaccineRepository.findVaccineByAvailableDoses(anyLong())).thenReturn(new ArrayList<Vaccine>());
        assertTrue(this.vaccineServ.findVaccineByAvailableDoses(1L).isEmpty());
        verify(this.vaccineRepository).findVaccineByAvailableDoses(anyLong());
    }

    @Test
    public void testFindVaccineByAvailableDoses2() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findVaccineByAvailableDoses(anyLong())).thenReturn(vaccineList);
        List<VaccineDTO> actualFindVaccineByAvailableDosesResult = this.vaccineServ.findVaccineByAvailableDoses(1L);
        assertEquals(1, actualFindVaccineByAvailableDosesResult.size());
        VaccineDTO getResult = actualFindVaccineByAvailableDosesResult.get(0);
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        assertEquals("Type", getResult.getType());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        verify(this.vaccineRepository).findVaccineByAvailableDoses(anyLong());
    }

    @Test
    public void testFindVaccineByAvailableDoses3() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        Vaccine vaccine1 = new Vaccine();
        vaccine1.setNumberOfShots(10);
        vaccine1.setResearchName("Research Name");
        vaccine1.setId(123L);
        vaccine1.setManufacturerName("Manufacturer Name");
        vaccine1.setAvailableDoses(0L);
        vaccine1.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine1);
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findVaccineByAvailableDoses(anyLong())).thenReturn(vaccineList);
        List<VaccineDTO> actualFindVaccineByAvailableDosesResult = this.vaccineServ.findVaccineByAvailableDoses(1L);
        assertEquals(2, actualFindVaccineByAvailableDosesResult.size());
        VaccineDTO getResult = actualFindVaccineByAvailableDosesResult.get(0);
        assertEquals("Type", getResult.getType());
        VaccineDTO getResult1 = actualFindVaccineByAvailableDosesResult.get(1);
        assertEquals("Type", getResult1.getType());
        assertEquals("Research Name", getResult1.getResearchName());
        assertEquals(10, getResult1.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult1.getManufacturerName());
        assertEquals(0L, getResult1.getAvailableDoses().longValue());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        verify(this.vaccineRepository).findVaccineByAvailableDoses(anyLong());
    }

    @Test
    public void testAddVaccine() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(1L);
        vaccine.setType("Type");
        Optional<Vaccine> ofResult = Optional.<Vaccine>of(vaccine);
        when(this.vaccineRepository.addVaccine((VaccineCommand) any())).thenReturn(ofResult);
        Optional<VaccineDTO> actualAddVaccineResult = this.vaccineServ
                .addVaccine(new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L));
        assertTrue(actualAddVaccineResult.isPresent());
        VaccineDTO getResult = actualAddVaccineResult.get();
        assertEquals(1L, getResult.getAvailableDoses().longValue());
        assertEquals("Type", getResult.getType());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        verify(this.vaccineRepository).addVaccine((VaccineCommand) any());
    }

    @Test
    public void testUpdateVaccine() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(1L);
        vaccine.setType("Type");
        Optional<Vaccine> ofResult = Optional.<Vaccine>of(vaccine);
        when(this.vaccineRepository.updateVaccine(anyString(), (VaccineCommand) any())).thenReturn(ofResult);
        Optional<VaccineDTO> actualUpdateVaccineResult = this.vaccineServ.updateVaccine("Research Name",
                new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L));
        assertTrue(actualUpdateVaccineResult.isPresent());
        VaccineDTO getResult = actualUpdateVaccineResult.get();
        assertEquals(1L, getResult.getAvailableDoses().longValue());
        assertEquals("Type", getResult.getType());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        verify(this.vaccineRepository).updateVaccine(anyString(), (VaccineCommand) any());
    }

    @Test
    public void testFindVaccinesByNumberOfAvailableDoses() {
        when(this.vaccineRepository.findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong()))
                .thenReturn(new ArrayList<Vaccine>());
        assertTrue(this.vaccineServ.findVaccinesByNumberOfAvailableDoses(1L, 1L).isEmpty());
        verify(this.vaccineRepository).findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong());
    }

    @Test
    public void testFindVaccinesByNumberOfAvailableDoses2() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong())).thenReturn(vaccineList);
        List<VaccineDTO> actualFindVaccinesByNumberOfAvailableDosesResult = this.vaccineServ
                .findVaccinesByNumberOfAvailableDoses(1L, 1L);
        assertEquals(1, actualFindVaccinesByNumberOfAvailableDosesResult.size());
        VaccineDTO getResult = actualFindVaccinesByNumberOfAvailableDosesResult.get(0);
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        assertEquals("Type", getResult.getType());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        verify(this.vaccineRepository).findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong());
    }

    @Test
    public void testFindVaccinesByNumberOfAvailableDoses3() {
        Vaccine vaccine = new Vaccine();
        vaccine.setNumberOfShots(10);
        vaccine.setResearchName("Research Name");
        vaccine.setId(123L);
        vaccine.setManufacturerName("Manufacturer Name");
        vaccine.setAvailableDoses(0L);
        vaccine.setType("Type");

        Vaccine vaccine1 = new Vaccine();
        vaccine1.setNumberOfShots(10);
        vaccine1.setResearchName("Research Name");
        vaccine1.setId(123L);
        vaccine1.setManufacturerName("Manufacturer Name");
        vaccine1.setAvailableDoses(0L);
        vaccine1.setType("Type");

        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        vaccineList.add(vaccine1);
        vaccineList.add(vaccine);
        when(this.vaccineRepository.findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong())).thenReturn(vaccineList);
        List<VaccineDTO> actualFindVaccinesByNumberOfAvailableDosesResult = this.vaccineServ
                .findVaccinesByNumberOfAvailableDoses(1L, 1L);
        assertEquals(2, actualFindVaccinesByNumberOfAvailableDosesResult.size());
        VaccineDTO getResult = actualFindVaccinesByNumberOfAvailableDosesResult.get(0);
        assertEquals("Type", getResult.getType());
        VaccineDTO getResult1 = actualFindVaccinesByNumberOfAvailableDosesResult.get(1);
        assertEquals("Type", getResult1.getType());
        assertEquals("Research Name", getResult1.getResearchName());
        assertEquals(10, getResult1.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult1.getManufacturerName());
        assertEquals(0L, getResult1.getAvailableDoses().longValue());
        assertEquals("Research Name", getResult.getResearchName());
        assertEquals(10, getResult.getNumberOfShots());
        assertEquals("Manufacturer Name", getResult.getManufacturerName());
        assertEquals(0L, getResult.getAvailableDoses().longValue());
        verify(this.vaccineRepository).findVaccinesByNumberOfAvailableDoses(anyLong(), anyLong());
    }

    @Test
    public void testDeleteVaccine() {
        doNothing().when(this.vaccineRepository).deleteVaccine(anyString());
        this.vaccineServ.deleteVaccine("Research Name");
        verify(this.vaccineRepository).deleteVaccine(anyString());
    }
}

