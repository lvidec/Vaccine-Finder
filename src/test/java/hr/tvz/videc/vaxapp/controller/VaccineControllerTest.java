package hr.tvz.videc.vaxapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.zaxxer.hikari.HikariDataSource;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.JdbcVaccineRepository;
import hr.tvz.videc.vaxapp.service.VaccineServ;
import hr.tvz.videc.vaxapp.service.VaccineService;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {VaccineController.class})
@ExtendWith(SpringExtension.class)
public class VaccineControllerTest {
    @Autowired
    private VaccineController vaccineController;

    @MockBean
    private VaccineService vaccineService;

    @Test
    public void testUpdateVaccine2() throws DataAccessException {
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any()))
                .thenReturn(new ArrayList<Object>());
        VaccineController vaccineController = new VaccineController(
                new VaccineServ(new JdbcVaccineRepository(jdbcTemplate)));
        ResponseEntity<VaccineDTO> actualUpdateVaccineResult = vaccineController.updateVaccine("Research Name",
                new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L));
        assertEquals(HttpStatus.CREATED, actualUpdateVaccineResult.getStatusCode());
        assertTrue(actualUpdateVaccineResult.hasBody());
        VaccineDTO body = actualUpdateVaccineResult.getBody();
        assertEquals("Manufacturer Name", body.getManufacturerName());
        assertEquals(1L, body.getAvailableDoses().longValue());
        assertEquals("Type", body.getType());
        assertEquals(10, body.getNumberOfShots());
        assertEquals("Research Name", body.getResearchName());
        verify(jdbcTemplate).query(anyString(), (org.springframework.jdbc.core.RowMapper<Object>) any(), (Object[]) any());
    }

    @Test
    public void testDeleteVaccine() throws Exception {
        doNothing().when(this.vaccineService).deleteVaccine(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/vaccine/{researchName}",
                "Research Name");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testDeleteVaccine2() throws Exception {
        doNothing().when(this.vaccineService).deleteVaccine(anyString());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/vaccine/{researchName}",
                "Research Name");
        deleteResult.contentType("Not all who wander are lost");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testGetAllVaccines() throws Exception {
        when(this.vaccineService.findAll()).thenReturn(new ArrayList<VaccineDTO>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vaccine");
        MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllVaccines2() throws Exception {
        when(this.vaccineService.findAll()).thenReturn(new ArrayList<VaccineDTO>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/vaccine");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetByAvailableDosses() throws Exception {
        when(this.vaccineService.findVaccineByAvailableDoses(anyLong())).thenReturn(new ArrayList<VaccineDTO>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/vaccine");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("availableDoses", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetByResearchName() throws Exception {
        when(this.vaccineService.findVaccineByResearchName(anyString()))
                .thenReturn(new VaccineDTO("Research Name", "Manufacturer Name", "Type", 10, 1L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vaccine/{researchName}",
                "Research Name");
        MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"researchName\":\"Research Name\",\"manufacturerName\":\"Manufacturer Name\",\"type\":\"Type\",\"numberOfShots\""
                                        + ":10,\"availableDoses\":1}")));
    }

    @Test
    public void testGetVaccinesByNumberOfAvailableDoses() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/vaccine/between");
        MockHttpServletRequestBuilder paramResult = getResult.param("availableDossesMax", String.valueOf(1L));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("availableDossesMin", String.valueOf(1L));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.vaccineController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

