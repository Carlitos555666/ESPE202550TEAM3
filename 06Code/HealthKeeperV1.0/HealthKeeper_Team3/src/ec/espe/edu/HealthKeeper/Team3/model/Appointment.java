package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.FileWriter;
import java.io.IOException;

public class Appointment {
    private String day;
    private String month;
    private String specialty;
    private String doctor;

    public Appointment(String day, String month, String specialty, String doctor) {
        this.day = day;
        this.month = month;
        this.specialty = specialty;
        this.doctor = doctor;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void saveToCSV(String patientName) {
        String fileName = "appointments.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(patientName).append(",")
                  .append(day).append(",")
                  .append(month).append(",")
                  .append(specialty).append(",")
                  .append(doctor).append("\n");
            writer.flush();
            System.out.println("Appointment saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving appointment: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", specialty='" + specialty + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}


