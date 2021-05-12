package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;

import java.util.List;

public interface SideEffectService {

    List<SideEffect> findAll();

    List<SideEffect> findByVaccine_VaxName(String vaxName);

}
