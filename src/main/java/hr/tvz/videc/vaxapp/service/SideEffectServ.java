package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        return sideEffectJpaRepository.findAll();
    }

    @Override
    public List<SideEffect> findByVaccine_VaxName(String vaxName) {
        return sideEffectJpaRepository.findByVaccine_VaxName(vaxName);
    }
}
