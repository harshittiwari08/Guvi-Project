package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patients (patient_id, user_id, medical_history) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patient.getId());
            ps.setString(2, patient.getId());
            ps.setString(3, patient.getMedicalHistory());
            ps.executeUpdate();
        }
    }

    public Patient getPatientById(String id) throws SQLException {
        String sql = "SELECT * FROM Patients WHERE patient_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getString("patient_id"), rs.getString("user_id"),
                        "placeholder_password", rs.getString("medical_history"));
            }
        }
        return null;
    }
}
