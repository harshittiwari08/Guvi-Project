package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO {
    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO Doctors (doctor_id, user_id, specialty) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getId());
            ps.setString(3, doctor.getSpecialty());
            ps.executeUpdate();
        }
    }

    public Doctor getDoctorById(String id) throws SQLException {
        String sql = "SELECT * FROM Doctors WHERE doctor_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Doctor(rs.getString("doctor_id"), rs.getString("user_id"),
                        "placeholder_password", rs.getString("specialty"));
            }
        }
        return null;
    }
}
