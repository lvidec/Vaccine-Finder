package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.model.Login.User;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUsername(String username);



}
