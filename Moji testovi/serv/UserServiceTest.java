package hr.tvz.videc.vaxapp.serv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import hr.tvz.videc.vaxapp.model.Login.Authority;
import hr.tvz.videc.vaxapp.model.Login.User;
import hr.tvz.videc.vaxapp.model.Login.UserDTO;
import hr.tvz.videc.vaxapp.repository.UserJpaRepository;

import java.util.HashSet;
import java.util.Optional;

import hr.tvz.videc.vaxapp.service.UserServ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServ.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @MockBean
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserServ userServ;

    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setLastName("Doe");
        user.setUsername("janedoe");
        user.setAuthorities(new HashSet<Authority>());
        user.setId(123L);
        user.setFirstName("Jane");
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userJpaRepository.findByUsername(anyString())).thenReturn(ofResult);
        UserDTO actualFindByUsernameResult = this.userServ.findByUsername("janedoe");
        assertEquals("janedoe", actualFindByUsernameResult.getUsername());
        assertEquals("Doe", actualFindByUsernameResult.getLastName());
        assertEquals(123L, actualFindByUsernameResult.getId().longValue());
        assertEquals("Jane", actualFindByUsernameResult.getFirstName());
        verify(this.userJpaRepository).findByUsername(anyString());
    }

    @Test
    public void testMapUserToUserDTO() {
        User user = new User();
        user.setAuthorities(new HashSet<Authority>());
        UserDTO actualMapUserToUserDTOResult = this.userServ.mapUserToUserDTO(user);
        assertNull(actualMapUserToUserDTOResult.getUsername());
        assertNull(actualMapUserToUserDTOResult.getLastName());
        assertNull(actualMapUserToUserDTOResult.getId());
        assertNull(actualMapUserToUserDTOResult.getFirstName());
    }

    @Test
    public void testMapUserToUserDTO2() {
        User user = mock(User.class);
        when(user.getAuthorities()).thenReturn(new HashSet<Authority>());
        when(user.getLastName()).thenReturn("foo");
        when(user.getFirstName()).thenReturn("foo");
        when(user.getUsername()).thenReturn("foo");
        when(user.getId()).thenReturn(1L);
        UserDTO actualMapUserToUserDTOResult = this.userServ.mapUserToUserDTO(user);
        assertEquals("foo", actualMapUserToUserDTOResult.getUsername());
        assertEquals("foo", actualMapUserToUserDTOResult.getLastName());
        assertEquals(1L, actualMapUserToUserDTOResult.getId().longValue());
        assertEquals("foo", actualMapUserToUserDTOResult.getFirstName());
        verify(user).getAuthorities();
        verify(user).getUsername();
        verify(user).getFirstName();
        verify(user).getLastName();
        verify(user).getId();
    }
}

