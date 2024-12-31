package Hospital;

public class Patient extends user {
    private String medicalHistory;

    public Patient(String id, String name, String password, String medicalHistory) {
        super(id, name, password);
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Medical History: " + medicalHistory);
    }
}

