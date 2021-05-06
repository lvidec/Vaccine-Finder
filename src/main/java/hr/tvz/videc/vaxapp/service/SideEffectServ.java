package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.SideEffect;
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
    public List<SideEffect> findBySideEffectId( Long id) {
        return sideEffectJpaRepository.findBySideEffectId(id);
    }
//
//    @Override
//    public List<SideEffect> findByVaxNameLike(String vaxName) {
//        return sideEffectJpaRepository.findByVaxNameLike(vaxName);
//    }
}
