package hr.tvz.videc.vaxapp.model.Login;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(targetEntity = Authority.class, mappedBy = "users")
    private Set<Authority> authorities;


    public User(Long id, String username, String password, String firstName, String lastName, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }

    public User() { }

    public User(String username, String password, Set<GrantedAuthority> grantedAuthorities) { }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

//    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Set<Authority> getAuthorities() { return authorities; }

    public void setAuthorities(Set<Authority> authorities) { this.authorities = authorities; }
}
