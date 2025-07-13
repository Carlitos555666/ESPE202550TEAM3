package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */

import java.io.FileWriter;
import java.io.IOException;

public class Caregiver {
    private String name;
    private String relationship;
    private String contactNumber;

    public Caregiver(String name, String relationship, String contactNumber) {
        this.name = name;
        this.relationship = relationship;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void saveToCSV(String patientName) {
        String fileName = "caregivers.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(patientName).append(",")
                  .append(name).append(",")
                  .append(relationship).append(",")
                  .append(contactNumber).append("\n");
            writer.flush();
            System.out.println("Caregiver saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving caregiver: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Caregiver{" +
                "name='" + name + '\'' +
                ", relationship='" + relationship + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
