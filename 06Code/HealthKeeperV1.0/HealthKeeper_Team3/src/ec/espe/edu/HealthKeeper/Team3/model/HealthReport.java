package ec.espe.edu.HealthKeeper.Team3.model;

import java.io.FileWriter;
import java.io.IOException;

public class HealthReport {
    public static void generateReport(Patient patient) {
        String fileName = "health_report.csv";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append("Name,Age,Gender,Medication,PreviousConditions,IsVitalsNormal\n");
            writer.append(patient.getName()).append(",");
            writer.append(String.valueOf(patient.getAge())).append(",");
            writer.append(patient.getGender()).append(",");
            writer.append(patient.getCurrentMedication()).append(",");
            writer.append(patient.getPreviousMedicalConditions()).append(",");
            
            boolean isNormal = patient.getVitalSigns() != null && patient.getVitalSigns().isNormal();
            writer.append(isNormal ? "Yes" : "No").append("\n");

            System.out.println("Health report saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing health report: " + e.getMessage());
        }
    }
}
