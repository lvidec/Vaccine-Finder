package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.Login.User;
import hr.tvz.videc.vaxapp.model.Login.UserDTO;
import hr.tvz.videc.vaxapp.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
public class UserServ implements UserService{

    private UserJpaRepository userRepository;

    public UserServ(UserJpaRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByUsername(String username) {
        return this.userRepository.findByUsername(username).map(this::mapUserToUserDTO).orElseThrow(EntityNotFoundException::new);
    }

    private UserDTO mapUserToUserDTO(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getAuthorities().stream().map(String::valueOf).collect(Collectors.toSet()));
    }

}
