package hr.tvz.videc.vaxapp.control;


import hr.tvz.videc.vaxapp.service.SideEffectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class SideEffectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SideEffectService sideEffectService;


    @Test
    public void getAllSideEffects_empty() throws Exception{
        when(sideEffectService.findAll()).thenReturn(Collections.emptyList());

        this.mockMvc.perform(
                get("/side-effect")
                .with(
                        user("test").password("test").roles("ADMIN")
                )
                .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }


    @Test
    public void getAllSideEffectsByVaccine_ResearchName() throws Exception{
        when(sideEffectService.findByVaccine_ResearchName("test")).thenReturn(Collections.emptyList());

        this.mockMvc.perform(
                get("/side-effect/?vaccineResearchName=test")
                        .with(
                                user("test").password("test").roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getAllSideEffectsByFrequencyGreaterThanEqualAndFrequencyLessThanEqual() throws Exception {
        when(sideEffectService.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(1, 50)).thenReturn(Collections.emptyList());

        this.mockMvc.perform(
                get("/side-effect/between/1/50")
                        .with(
                                user("test").password("test").roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }


}
