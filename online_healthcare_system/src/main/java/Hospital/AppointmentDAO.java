package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentDAO {
    public void addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO Appointments (appointment_id, doctor_id, patient_id, appointment_date) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, appointment.getDoctorId());
            ps.setString(2, appointment.getDoctorId());
            ps.setString(3, appointment.getPatientId());
            ps.setString(4, appointment.getDate());
            ps.executeUpdate();
        }
    }

    public Appointment getAppointmentById(String id) throws SQLException {
        String sql = "SELECT * FROM Appointments WHERE appointment_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Appointment(rs.getString("appointment_id"),
                        rs.getString("doctor_id"),
                        rs.getString("patient_id"),
                        rs.getString("appointment_date"));
            }
        }
        return null;
    }
}
