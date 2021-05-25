package hr.tvz.videc.vaxapp.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.service.SideEffectService;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SideEffectController.class})
@ExtendWith(SpringExtension.class)
public class SideEffectControllerTest {
    @Autowired
    private SideEffectController sideEffectController;

    @MockBean
    private SideEffectService sideEffectService;

    @Test
    public void testFindAll() throws Exception {
        when(this.sideEffectService.findAll()).thenReturn(new ArrayList<SideEffect>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/side-effect");
        MockMvcBuilders.standaloneSetup(this.sideEffectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testFindByVaccine_ResearchName() throws Exception {
        when(this.sideEffectService.findByVaccine_ResearchName(anyString())).thenReturn(new ArrayList<SideEffect>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/side-effect")
                .param("vaccineResearchName", "foo");
        MockMvcBuilders.standaloneSetup(this.sideEffectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqual() throws Exception {
        when(this.sideEffectService.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(anyLong(), anyLong()))
                .thenReturn(new ArrayList<SideEffect>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/side-effect/between/{min}/{max}", 1L,
                1L);
        MockMvcBuilders.standaloneSetup(this.sideEffectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqual2() throws Exception {
        when(this.sideEffectService.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(anyLong(), anyLong()))
                .thenReturn(new ArrayList<SideEffect>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/side-effect/between/{min}/{max}", 1L, 1L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.sideEffectController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }
}

