package ec.espe.edu.HealthKeeper.Team3.view;

import ec.espe.edu.HealthKeeper.Team3.model.*;
import java.util.Scanner;

/**
 * Health Keeper Menu
 * 
 * Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
public class Menu {

    /**
     * Starts the main menu loop for the Health Keeper system.
     */
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
                case 1 -> {
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

                    patient = new Patient(name, age, gender, previousConditions, medication);
                    patient.saveToCSV();
                    System.out.println("Patient registered successfully.");
                }

                case 2 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
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

                case 4 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    System.out.print("Enter caregiver's name: ");
                    String caregiverName = scanner.nextLine();
                    System.out.print("Enter relationship: ");
                    String relationship = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    patient.addCaregiver(caregiverName, relationship, contactNumber);
                    System.out.println("Caregiver added.");
                }

                case 5 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    System.out.print("Enter breakfast: ");
                    String breakfast = scanner.nextLine();
                    System.out.print("Enter lunch: ");
                    String lunch = scanner.nextLine();
                    System.out.print("Enter dinner: ");
                    String dinner = scanner.nextLine();
                    System.out.print("Enter snacks: ");
                    String snacks = scanner.nextLine();
                    patient.assignDietPlan(breakfast, lunch, dinner, snacks);
                    System.out.println("Diet plan assigned.");
                }

                case 6 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    System.out.print("Enter new medication: ");
                    String newMedication = scanner.nextLine();
                    patient.updateMedication(newMedication);
                }

                case 7 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                    } else {
                        patient.saveVitalSignsToCSV();
                        System.out.println("Vital signs saved to file.");
                    }
                }

                case 8 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    System.out.print("Enter activity type: ");
                    String activityType = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter calories burned: ");
                    int caloriesBurned = scanner.nextInt();
                    scanner.nextLine();
                    patient.recordPhysicalActivity(activityType, duration, caloriesBurned);
                    System.out.println("Physical activity recorded.");
                }

                case 9 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                        break;
                    }
                    HealthReport.generateReport(patient);
                    System.out.println("Health report recorded.");
                }

                case 10 -> {
                    if (patient == null) {
                        System.out.println("Please register a patient first.");
                    } else {
                        patient.saveAllData();
                        System.out.println("All patient data saved.");
                    }
                }

                case 11 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}


