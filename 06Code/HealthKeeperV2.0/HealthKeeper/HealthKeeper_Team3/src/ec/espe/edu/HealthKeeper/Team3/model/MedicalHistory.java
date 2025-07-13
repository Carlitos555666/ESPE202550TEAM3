package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MedicalHistory {
    private String previousConditions;

    public MedicalHistory(String previousConditions) {
        this.previousConditions = previousConditions;
    }

    public String getPreviousConditions() {
        return previousConditions;
    }

    public void setPreviousConditions(String previousConditions) {
        this.previousConditions = previousConditions;
    }

    public void displayHistory() {
        System.out.println("Medical History:");
        System.out.println("Previous conditions: " + previousConditions);
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(previousConditions);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing medical history to file: " + e.getMessage());
        }
    }
}


