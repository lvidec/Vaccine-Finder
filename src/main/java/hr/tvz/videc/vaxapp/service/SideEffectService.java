package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect;

import java.util.List;
import java.util.Optional;

public interface SideEffectService {

    List<SideEffect> findBySideEffectId( Long id);

//    List<SideEffect> findBySideEffectId(String vaxName);

}