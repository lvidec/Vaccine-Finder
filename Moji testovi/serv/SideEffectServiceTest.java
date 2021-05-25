package hr.tvz.videc.vaxapp.serv;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;
import hr.tvz.videc.vaxapp.service.SideEffectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
public class SideEffectServiceTest {

    @Autowired
    SideEffectService sideEffectService;

    @MockBean
    SideEffectJpaRepository sideEffectJpaRepository;

    @Test
    public void testFindAll(){
        when(sideEffectJpaRepository.findAll()).thenReturn(
            Stream.of(new SideEffect("isus", "isus kristijan", 1, null),
                      new SideEffect("bog", "mockova", 2, null))
                    .collect(Collectors.toList())
        );

        Assertions.assertEquals(sideEffectService.findAll().size(), 2);
    }

    @Test
    public void testFindByVaccine_ResearchName(){
        when(sideEffectJpaRepository.findByVaccine_ResearchName(anyString())).thenReturn(
                Stream.of(new SideEffect("researchName1", "isus kristijan", 1, null),
                        new SideEffect("researchName2", "mockova", 2, null))
                        .collect(Collectors.toList())
        );

        Assertions.assertEquals(sideEffectService.findByVaccine_ResearchName("testResearchName").size(), 2);
    }

    @Test
    public void testFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(){
        when(sideEffectJpaRepository.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(1, 50)).thenReturn(
                Stream.of(new SideEffect("freq1", "frekvencije su sve", 1, null))
                .collect(Collectors.toList())
        );

        Assertions.assertEquals(sideEffectService.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(1, 50).size(), 1);
    }

}
