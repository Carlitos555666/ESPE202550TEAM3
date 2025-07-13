package ec.espe.edu.HealthKeeper.Team3.view;

import ec.espe.edu.HealthKeeper.Team3.model.*;
import java.util.Scanner;

/**
 * Health Keeper Menu
 * 
 * Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
public class Menu {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;

        while (true) {
            System.out.println("\n=== Health Keeper System Menu ===");
            System.out.println("1. Register patient");
            System.out.println("2. Record vital signs");
            System.out.println("3. Schedule medical appointment");
            System.out.println("4. Add caregiver");
            System.out.println("5. Assign diet plan");
            System.out.println("6. Update medication");
            System.out.println("7. Save vital signs to file");
            System.out.println("8. Record physical activity");
            System.out.println("9. Record health report");
            System.out.println("10. Save all patient data");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> patient = registerPatient(scanner);
                case 2 -> recordVitalSigns(scanner, patient);
                // Los demás casos se mantienen igual (no mostrados aquí por brevedad)
                case 3 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    System.out.print("Enter appointment day: ");
                    String day = scanner.nextLine();
                    System.out.print("Enter appointment month: ");
                    String month = scanner.nextLine();
                    System.out.print("Enter specialty: ");
                    String specialty = scanner.nextLine();
                    System.out.print("Enter doctor's name: ");
                    String doctor = scanner.nextLine();
                    patient.scheduleMedicalAppointment(day, month, specialty, doctor);
                    System.out.println("Medical appointment scheduled.");
                }

                // ... resto de los casos iguales

                case 11 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    /**
     * Registers a new patient using input from the console.
     */
    private Patient registerPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter previous medical conditions: ");
        String previousConditions = scanner.nextLine();
        System.out.print("Enter current medication: ");
        String medication = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, previousConditions, medication);
        patient.saveToCSV();
        System.out.println("Patient registered successfully.");
        return patient;
    }

    /**
     * Records vital signs for the given patient.
     */
    private void recordVitalSigns(Scanner scanner, Patient patient) {
        if (patient == null) {
            System.out.println("Please register a patient first.");
            return;
        }
        try {
            System.out.print("Enter temperature: ");
            float temperature = Float.parseFloat(scanner.nextLine().replace(",", "."));
            System.out.print("Enter pulse: ");
            int pulse = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter systolic blood pressure: ");
            int bloodPressureSys = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter diastolic blood pressure: ");
            int bloodPressureDias = Integer.parseInt(scanner.nextLine());

            VitalSign vitalSigns = new VitalSign(temperature, pulse, bloodPressureSys, bloodPressureDias);
            patient.setVitalSigns(vitalSigns);

            if (patient.recordVitalSigns()) {
                System.out.println("Vital signs recorded successfully and are within normal range.");
            } else {
                System.out.println("Vital signs recorded, but are out of normal range.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }
}
