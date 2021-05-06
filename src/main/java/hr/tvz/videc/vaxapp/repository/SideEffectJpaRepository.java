package hr.tvz.videc.vaxapp.repository;


import hr.tvz.videc.vaxapp.model.SideEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideEffectJpaRepository extends JpaRepository<SideEffect, Long> {

//    @Query(value = "SELECT * FROM SideEffect", nativeQuery = true)
    List<SideEffect> findBySideEffectId(Long id);

//    List<SideEffect> findByVaxNameLike(String vaxName);

}
