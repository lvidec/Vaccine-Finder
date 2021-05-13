package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;

import java.util.List;

public interface SideEffectService {

    List<SideEffect> findAll();

    List<SideEffect> findByVaccine_ResearchName(String researchName);

    List<SideEffect> findVaccinesByNumberOfAvailableDoses(long freqMin, long freqMax);
}
