package hr.tvz.videc.vaxapp.repository;


import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideEffectJpaRepository extends JpaRepository<SideEffect, Long> {

    List<SideEffect> findAll();

    List<SideEffect> findByVaccine_VaxName(String vaxName);

}
