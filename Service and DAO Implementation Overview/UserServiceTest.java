package Hospital.DAOTest;

import com.dao.UserDAO;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() throws Exception {
        when(userDAO.addUser(anyString(), anyString(), anyString())).thenReturn(true);

        boolean result = userService.registerUser("john_doe", "password123", "Doctor");
        Assertions.assertTrue(result);
        verify(userDAO, times(1)).addUser("john_doe", "password123", "Doctor");
    }

    @Test
    void testGetUserById() throws Exception {
        when(userDAO.findUserById(anyInt())).thenReturn(mock(ResultSet.class));

        ResultSet result = userService.getUserById(1);
        Assertions.assertNotNull(result);
        verify(userDAO, times(1)).findUserById(1);
    }
}

