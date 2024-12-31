package Hospital;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    
    public static void main(String[] args) {
        // Initialize some data
        doctors.add(new Doctor("D001", "Dr. Smith", "password", "Cardiology"));
        patients.add(new Patient("P001", "John Doe", "password", "Diabetes"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login as Doctor");
            System.out.println("2. Login as Patient");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    doctorLogin(scanner);
                    break;
                case 2:
                    patientLogin(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void doctorLogin(Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        String id = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id) && doctor.getPassword().equals(password)) {
                System.out.println("Welcome, Dr. " + doctor.getName());
                doctorMenu(doctor, scanner);
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    private static void patientLogin(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        String id = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        for (Patient patient : patients) {
            if (patient.getId().equals(id) && patient.getPassword().equals(password)) {
                System.out.println("Welcome, " + patient.getName());
                patientMenu(patient, scanner);
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    private static void doctorMenu(Doctor doctor, Scanner scanner) {
        while (true) {
            System.out.println("1. View Appointments");
            System.out.println("2. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Appointments for Dr. " + doctor.getName() + ":");
                for (Appointment appointment : appointments) {
                    if (appointment.getDoctorId().equals(doctor.getId())) {
                        appointment.displayDetails();
                    }
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void patientMenu(Patient patient, Scanner scanner) {
        while (true) {
            System.out.println("1. Book Appointment");
            System.out.println("2. View Medical History");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                bookAppointment(patient, scanner);
            } else if (choice == 2) {
                System.out.println("Medical History: " + patient.getMedicalHistory());
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void bookAppointment(Patient patient, Scanner scanner) {
        System.out.println("Available Doctors:");
        for (Doctor doctor : doctors) {
            doctor.displayDetails();
        }

        System.out.print("Enter Doctor ID to book: ");
        String doctorId = scanner.next();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.next();

        appointments.add(new Appointment("A" + (appointments.size() + 1), doctorId, patient.getId(), date));
        System.out.println("Appointment booked successfully.");
    }
}
