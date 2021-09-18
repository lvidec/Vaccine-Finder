package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.Login.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findByUsername(String username);

    List<UserDTO> findAllUsers();

}
