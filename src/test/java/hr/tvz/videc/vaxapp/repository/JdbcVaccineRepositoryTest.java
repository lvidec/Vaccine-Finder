//package hr.tvz.videc.vaxapp.repository;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
//import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {JdbcVaccineRepository.class, JdbcTemplate.class})
//@ExtendWith(SpringExtension.class)
//public class JdbcVaccineRepositoryTest {
//
//    @MockBean
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private JdbcVaccineRepository jdbcVaccineRepository;
//
//    @Test
//    public void testFindAll() throws DataAccessException {
//        ArrayList<Object> objectList = new ArrayList<Object>();
//        when(this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any()))
//                .thenReturn(objectList);
//        List<Vaccine> actualFindAllResult = this.jdbcVaccineRepository.findAll();
//        assertSame(objectList, actualFindAllResult);
//        assertTrue(actualFindAllResult.isEmpty());
//        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any());
//    }
//
//    @Test
//    public void testFindVaccineByResearchName() throws DataAccessException {
//        when(
//                this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
//                .thenReturn(new ArrayList<Object>());
//        assertFalse(this.jdbcVaccineRepository.findVaccineByResearchName("Research Name").isPresent());
//        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(),
//                (Object[]) any());
//    }
//
//    @Test
//    public void testFindVaccineByAvailableDoses() throws DataAccessException {
//        when(
//                this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
//                .thenReturn(new ArrayList<Object>());
//        assertTrue(this.jdbcVaccineRepository.findVaccineByAvailableDoses(1L).isEmpty());
//        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(),
//                (Object[]) any());
//    }
//
//    @Test
//    public void testFindVaccinesByNumberOfAvailableDoses() throws DataAccessException {
//        when(
//                this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
//                .thenReturn(new ArrayList<Object>());
//        assertTrue(this.jdbcVaccineRepository.findVaccinesByNumberOfAvailableDoses(1L, 1L).isEmpty());
//        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(),
//                (Object[]) any());
//    }
//
////    @Test
////    @DirtiesContext
//////  MOJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
////    public void testAddVaccineMoj(){
////        jdbcVaccineRepository.addVaccine(new VaccineCommand("mockResearchName", "mockManufacturerName", "mRna", 2, 10000));
////
////        List<Vaccine> vaccineList = jdbcVaccineRepository.findAll();
////        Assertions.assertNotNull(vaccineList);
////        Assertions.assertEquals(vaccineList.size(), 4);
////    }
////
////    @Test
////    public void testAddVaccine() {
////        VaccineCommand vaccineCommand = mock(VaccineCommand.class);
////        when(vaccineCommand.getAvailableDoses()).thenReturn(1L);
////        when(vaccineCommand.getNumberOfShots()).thenReturn(1);
////        when(vaccineCommand.getType()).thenReturn("foo");
////        when(vaccineCommand.getManufacturerName()).thenReturn("foo");
////        when(vaccineCommand.getResearchName()).thenReturn("foo");
////        this.jdbcVaccineRepository.addVaccine(vaccineCommand);
////        verify(vaccineCommand).getNumberOfShots();
////        verify(vaccineCommand).getAvailableDoses();
////        verify(vaccineCommand).getType();
////        verify(vaccineCommand).getManufacturerName();
////        verify(vaccineCommand).getResearchName();
////    }
//
//    @Test
//    public void testUpdateVaccine() throws DataAccessException {
//        when(
//                this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
//                .thenReturn(new ArrayList<Object>());
//        assertFalse(this.jdbcVaccineRepository
//                .updateVaccine("Research name", new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L))
//                .isPresent());
//        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(),
//                (Object[]) any());
//    }
//
////    @Test
////    public void testUpdateVaccine2() throws DataAccessException {
////        ArrayList<Object> objectList = new ArrayList<Object>();
////        objectList.add("42");
////        when(this.jdbcTemplate.update(anyString(), (Object[]) any())).thenReturn(1);
////        when(
////                this.jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
////                .thenReturn(objectList);
////        this.jdbcVaccineRepository.updateVaccine("Research name",
////                new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L));
////        verify(this.jdbcTemplate).update(anyString(), (Object[]) any());
////        verify(this.jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(),
////                (Object[]) any());
////    }
//
//    @Test
//    public void testDeleteVaccine() throws DataAccessException {
//        when(this.jdbcTemplate.update(anyString(), (Object[]) any())).thenReturn(1);
//        this.jdbcVaccineRepository.deleteVaccine("Research name");
//        verify(this.jdbcTemplate).update(anyString(), (Object[]) any());
//    }
//}
//
