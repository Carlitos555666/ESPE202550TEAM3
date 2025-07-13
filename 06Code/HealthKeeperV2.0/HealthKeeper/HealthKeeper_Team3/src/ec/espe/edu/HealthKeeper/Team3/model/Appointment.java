package ec.espe.edu.HealthKeeper.Team3.model;

import java.io.FileWriter;
import java.io.IOException;

public class Appointment {
    private String day;
    private String month;
    private String year;
    private String specialty;
    private String doctor;

    public Appointment(String day, String month, String year, String specialty, String doctor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.specialty = specialty;
        this.doctor = doctor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void saveToCSV(String patientName) {
        String fileName = "appointments.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(patientName).append(",")
                  .append(day).append(",")
                  .append(month).append(",")
                  .append(year).append(",")
                  .append(specialty).append(",")
                  .append(doctor).append("\n");
            writer.flush();
            System.out.println("Appointment saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving appointment: " + e.getMessage());
        }
    }

    public void saveToMongoDB() {
        MongoDBDataManager mongoDB = new MongoDBDataManager();
        String collectionName = "appointments";
        String document = String.format(
            "{ \"day\": \"%s\", \"month\": \"%s\", \"year\": \"%s\", " +
            "\"specialty\": \"%s\", \"doctor\": \"%s\" }",
            day, month, year, specialty, doctor
        );
        mongoDB.create(collectionName, document);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", specialty='" + specialty + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}

