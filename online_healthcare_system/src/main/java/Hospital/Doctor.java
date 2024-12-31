package Hospital;

public class Doctor extends user {
    private String specialty;

    public Doctor(String id, String name, String password, String specialty) {
        super(id, name, password);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialty: " + specialty);
    }
}
