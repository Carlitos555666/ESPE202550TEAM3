
package ec.espe.edu.HealthKeeper.Team3.view;

import ec.espe.edu.HealthKeeper.Team3.model.Patient;
import ec.espe.edu.HealthKeeper.Team3.model.VitalSign;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        int option=0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Agendar cita medica");
            System.out.println("3. Actualizar medicacion");
            System.out.println("4. Registrar signos vitales");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            
            if (!scanner.hasNextInt()) {
                System.out.println("\n Debe ingresar un numero entero");
                scanner.nextLine(); 
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Edad: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("\n Debe ingresar un numero entero");
                        scanner.nextLine();
                        break;
                    }
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Genero: ");
                    String gender = scanner.nextLine();

                    System.out.print("Condiciones medicas previas: ");
                    String previousConditions = scanner.nextLine();

                    System.out.print("Medicacion actual: ");
                    String medication = scanner.nextLine();

                    VitalSign vitalSigns = new VitalSign(0.0f, 0, 0);
                    patient = new Patient(name, age, gender, previousConditions, medication, vitalSigns);
                    System.out.println("\n Paciente registrado correctamente.");
                    break;

                case 2:
                    if (patient != null) {
                        System.out.print("Dia de la cita: ");
                        String day = scanner.nextLine();
                        System.out.print("Mes de la cita: ");
                        String month = scanner.nextLine();
                        System.out.print("Especialidad: ");
                        String specialty = scanner.nextLine();
                        System.out.print("Nombre del doctor: ");
                        String doctor = scanner.nextLine();

                        patient.scheduleMedicalAppointment(day, month, specialty, doctor);
                        
                    } else {
                        System.out.println("Primero debes registrar un paciente.");
                    }
                    break;

                case 3:
                    if (patient != null) {
                        System.out.print("Ingresa nueva medicacion: ");
                        String newMed = scanner.nextLine();
                        patient.updateMedication(newMed);
                    } else {
                        System.out.println("Primero debes registrar un paciente.");
                    }
                    break;

                case 4:
                    if (patient != null) {
                        try {
                            System.out.print("Ingrese temperatura (C): ");
                            float temperature = Float.parseFloat(scanner.nextLine());

                            System.out.print("Ingrese pulso (latidos por minuto): ");
                            if (!scanner.hasNextInt()) {
                                System.out.println("Debe ingresar un numero entero");
                                scanner.nextLine();
                                break;
                            }
                            int pulse = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese presion arterial (sistolica): ");
                            if (!scanner.hasNextInt()) {
                                System.out.println("Debe ingresar un numero entero");
                                scanner.nextLine();
                                break;
                            }
                            int bloodPressure = scanner.nextInt();
                            scanner.nextLine();

                            VitalSign newVitals = new VitalSign(temperature, pulse, bloodPressure);
                            patient.setVitalSigns(newVitals);

                            if (patient.recordVitalSigns()) {
                                System.out.println("\n Signos vitales dentro de rango normal.");
                            } else {
                                System.out.println("\n Signos vitales fuera de lo normal.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un numero entero");
                        }
                    } else {
                        System.out.println("Primero debes registrar un paciente.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (option != 5);

        scanner.close();
    }
}
