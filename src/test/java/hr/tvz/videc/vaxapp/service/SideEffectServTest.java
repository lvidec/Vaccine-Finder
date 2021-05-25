package hr.tvz.videc.vaxapp.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SideEffectServ.class})
@ExtendWith(SpringExtension.class)
public class SideEffectServTest {
    @MockBean
    private SideEffectJpaRepository sideEffectJpaRepository;

    @Autowired
    private SideEffectServ sideEffectServ;

    @Test
    public void testFindAll() {
        ArrayList<SideEffect> sideEffectList = new ArrayList<SideEffect>();
        when(this.sideEffectJpaRepository.findAll()).thenReturn(sideEffectList);
        List<SideEffect> actualFindAllResult = this.sideEffectServ.findAll();
        assertSame(sideEffectList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.sideEffectJpaRepository, times(2)).findAll();
    }

    @Test
    public void testFindByVaccine_ResearchName() {
        ArrayList<SideEffect> sideEffectList = new ArrayList<SideEffect>();
        when(this.sideEffectJpaRepository.findByVaccine_ResearchName(anyString())).thenReturn(sideEffectList);
        List<SideEffect> actualFindByVaccine_ResearchNameResult = this.sideEffectServ
                .findByVaccine_ResearchName("Research Name");
        assertSame(sideEffectList, actualFindByVaccine_ResearchNameResult);
        assertTrue(actualFindByVaccine_ResearchNameResult.isEmpty());
        verify(this.sideEffectJpaRepository).findByVaccine_ResearchName(anyString());
    }

    @Test
    public void testFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqual() {
        ArrayList<SideEffect> sideEffectList = new ArrayList<SideEffect>();
        when(this.sideEffectJpaRepository.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(anyFloat(), anyFloat()))
                .thenReturn(sideEffectList);
        List<SideEffect> actualFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqualResult = this.sideEffectServ
                .findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(1L, 1L);
        assertSame(sideEffectList, actualFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqualResult);
        assertTrue(actualFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqualResult.isEmpty());
        verify(this.sideEffectJpaRepository).findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(anyFloat(),
                anyFloat());
    }
}

