package Hospital;

import com.dao.UserDAO;
import java.sql.ResultSet;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(String username, String password, String role) throws Exception {
        return userDAO.addUser(username, password, role);
    }

    public ResultSet getUserById(int userId) throws Exception {
        return userDAO.findUserById(userId);
    }
}
