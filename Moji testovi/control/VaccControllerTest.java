//package hr.tvz.videc.vaxapp.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
//import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
//import hr.tvz.videc.vaxapp.service.VaccineService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@AutoConfigureMockMvc
//@SpringBootTest
//public class VaccControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    VaccineService vaccineService;
//
//
//    @Test
//    public void getAllVaccines_empty() throws Exception{
//        when(vaccineService.findAll()).thenReturn(Collections.emptyList());
//
//        this.mockMvc.perform(
//                get("/vaccine")
//                        .with(
//                                user("test").password("test").roles("ADMIN")
//                        )
//                        .with(csrf())
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//    @Test
//    public void getVaccineByResearchName() throws Exception{
//        when(vaccineService.findVaccineByResearchName("test")).thenReturn(new VaccineDTO("test","test","test",1,100L));
//
//        this.mockMvc.perform(
//                get("/vaccines/test")
//                        .with(
//                                user("test").password("test").roles("ADMIN")
//                        )
//                        .with(csrf())
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//
//    @Test
//    public void getAllVaccinesByAvailableDoses() throws Exception{
//        when(vaccineService.findVaccineByAvailableDoses(300)).thenReturn(Collections.emptyList());
//
//        this.mockMvc.perform(
//                get("/vaccine/?availableDoses=300")
//                        .with(
//                                user("test").password("test").roles("ADMIN")
//                        )
//                        .with(csrf())
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//
//    @Test
//    public void getAllVaccinesByNumberOfAvailableDoses() throws Exception{
//        when(vaccineService.findVaccinesByNumberOfAvailableDoses(101, 100000)).thenReturn(Collections.emptyList());
//
//        this.mockMvc.perform(
//                get("/vaccine/between/?min=101&max=100000")
//                        .with(
//                                user("test").password("test").roles("ADMIN")
//                        )
//                        .with(csrf())
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//
//    @Test
//    public void addVaccine() throws Exception {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        VaccineCommand vaccineCommand = new VaccineCommand("Research Name", "Manufacturer Name", "Type", 10, 1L);
//
//        when(vaccineService.addVaccine(any(VaccineCommand.class)))
//                .thenReturn(
//                        Optional.of(new VaccineDTO("Research Name", "Manufacturer Name", "Type", 10, 1L))
//        );
//
//        this.mockMvc.perform(
//                post("/vaccine")
//                        .with(
//                                user("test").password("test").roles("ADMIN")
//                        )
//                        .with(csrf())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(vaccineCommand))
////                .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.researchName").value("Research Name"))
//                .andExpect(jsonPath("$.manufacturerName").value("Manufacturer Name"));
//    }
//
//
//    @Test
//    public void updateVaccine() throws Exception {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        VaccineCommand vaccineCommand = new VaccineCommand("isus","isus","test",1,100L);
//
//        this.mockMvc.perform(
//                put("/vaccine/test")
//                    .with(
//                            user("test").password("test").roles("ADMIN")
//                    )
//                    .with(csrf())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(vaccineCommand))
//                .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.researchName").value("isus"))
//                .andExpect(jsonPath("$.manufacturerName").value("isus"));
//    }
//
//
//    @Test
//    public void deleteVaccine() throws Exception {
//
//        this.mockMvc.perform(
//                delete("/vaccine/test")
//                    .with(
//                            user("test").password("test").roles("ADMIN")
//                    )
//                    .with(csrf())
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk());
//
//    }
//
//
//
//
//
//
//}
