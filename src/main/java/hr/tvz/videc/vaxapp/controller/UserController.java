package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.model.Login.User;
import hr.tvz.videc.vaxapp.model.Login.UserDTO;
import hr.tvz.videc.vaxapp.security.DomainUserDetailsService;
import hr.tvz.videc.vaxapp.security.SecurityUtils;
import hr.tvz.videc.vaxapp.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private DomainUserDetailsService domainUserDetailsService;

    private UserService userService;

    public UserController(DomainUserDetailsService domainUserDetailsService, UserService userService){
        this.domainUserDetailsService = domainUserDetailsService;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/current-user")
    public UserDTO getCurrentUser(){

        String username = SecurityUtils.getCurrentUserUsername().orElseThrow(EntityNotFoundException::new);
        return this.userService.findByUsername(username);

    }


}
