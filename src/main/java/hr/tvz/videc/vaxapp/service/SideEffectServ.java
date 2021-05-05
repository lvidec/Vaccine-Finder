package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.repository.SideEffectJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SideEffectServ implements SideEffectService {

    private SideEffectJpaRepository sideEffectJpaRepository;

    public SideEffectServ(SideEffectJpaRepository sideEffectJpaRepository){
        this.sideEffectJpaRepository = sideEffectJpaRepository;
    }

    public SideEffectServ(){}

    @Override
    public List<SideEffect> findAll() {
        return sideEffectJpaRepository.findAll();
    }
//
//    @Override
//    public List<SideEffect> findByVaxNameLike(String vaxName) {
//        return sideEffectJpaRepository.findByVaxNameLike(vaxName);
//    }
}
