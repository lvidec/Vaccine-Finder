package hr.tvz.videc.vaxapp.repo;

import hr.tvz.videc.vaxapp.model.Login.User;
import hr.tvz.videc.vaxapp.repository.UserJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserJpaRepositoryTest {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void testFindByUsername(){
        Optional<User> user = userJpaRepository.findByUsername("admin");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.get().getFirstName(), "Admin");
    }

}
