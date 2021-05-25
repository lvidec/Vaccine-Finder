package hr.tvz.videc.vaxapp.repo;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SideEffectJpaRepositoryTest {

    @Autowired
    SideEffectJpaRepository sideEffectJpaRepository;

    @Test
    public void testJpaFindAll(){
        List<SideEffect> sideEffects = sideEffectJpaRepository.findAll();
        Assertions.assertNotNull(sideEffects);
        Assertions.assertEquals(sideEffects.size(), 4);
    }

    @Test
    public void testFindByVaccine_ResearchName(){
        List<SideEffect> sideEffects = sideEffectJpaRepository.findByVaccine_ResearchName("Pfizer-BioNTech");
        Assertions.assertNotNull(sideEffects);
        Assertions.assertEquals(sideEffects.size(), 2);
    }

    @Test
    public void testFindByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(){
        List<SideEffect> sideEffects = sideEffectJpaRepository.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(2, 100);
        Assertions.assertNotNull(sideEffects);
        Assertions.assertEquals(sideEffects.size(), 3);
    }

}
