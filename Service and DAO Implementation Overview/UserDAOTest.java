package Hospital.DAOTest;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.sql.*;
import static org.mockito.Mockito.*;

public class UserDAOTest {
    private UserDAO userDAO;
    private Connection connection;
    private PreparedStatement preparedStatement;

    @BeforeEach
    void setup() {
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        userDAO = new UserDAO(connection);
    }

    @Test
    void testAddUser() throws Exception {
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        boolean result = userDAO.addUser("john_doe", "password123", "Doctor");
        Assertions.assertTrue(result);
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testFindUserById() throws Exception {
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(mock(ResultSet.class));

        ResultSet resultSet = userDAO.findUserById(1);
        Assertions.assertNotNull(resultSet);
        verify(preparedStatement, times(1)).executeQuery();
    }
}
