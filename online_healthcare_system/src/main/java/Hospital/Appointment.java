package Hospital;

public class Appointment {
    private String appointmentId;
    private String doctorId;
    private String patientId;
    private String date;

    public Appointment(String appointmentId, String doctorId, String patientId, String date) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }
    
    public String getDoctorId() {
        return doctorId;
    }

    public void displayDetails() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Date: " + date);
    }
}

