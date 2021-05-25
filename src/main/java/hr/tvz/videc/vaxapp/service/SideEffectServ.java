package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SideEffectServ implements SideEffectService {

    @Autowired
    private SideEffectJpaRepository sideEffectJpaRepository;

    public SideEffectServ(SideEffectJpaRepository sideEffectJpaRepository){
        this.sideEffectJpaRepository = sideEffectJpaRepository;
    }

    public SideEffectServ(){}

    @Override
    public List<SideEffect> findAll() {
        System.out.println("Getting data from mock junit " + sideEffectJpaRepository.findAll());
        return sideEffectJpaRepository.findAll();
    }

    @Override
    public List<SideEffect> findByVaccine_ResearchName(String researchName) {
        return sideEffectJpaRepository.findByVaccine_ResearchName(researchName);
    }

    @Override
    public List<SideEffect> findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(long freqMin, long freqMax) {
        return sideEffectJpaRepository.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(freqMin, freqMax);
    }


}
