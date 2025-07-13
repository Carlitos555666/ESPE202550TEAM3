package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Medication {
    private String currentMedication;

    public Medication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public void displayMedication() {
        System.out.println("Current medication: " + currentMedication);
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(currentMedication);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing medication to file: " + e.getMessage());
        }
    }
}
