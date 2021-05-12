package hr.tvz.videc.vaxapp.service;

import hr.tvz.videc.vaxapp.model.Login.UserDTO;

public interface UserService {

    UserDTO findByUsername(String username);
}
