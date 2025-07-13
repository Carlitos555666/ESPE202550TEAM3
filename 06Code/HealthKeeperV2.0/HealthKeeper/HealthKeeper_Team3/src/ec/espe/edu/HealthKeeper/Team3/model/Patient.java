package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import ec.espe.edu.HealthKeeper.Team3.controller.Main;

public class Patient {
    private String name;
    private int age;
    private String gender;
    private String previousMedicalConditions;
    private String currentMedication;
    private VitalSign vitalSigns;
    private List<PhysicalActivity> physicalActivities = new ArrayList<>();

    public Patient(String name, int age, String gender, String previousMedicalConditions, String currentMedication) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.previousMedicalConditions = previousMedicalConditions;
        this.currentMedication = currentMedication;
        this.vitalSigns = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPreviousMedicalConditions() {
        return previousMedicalConditions;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public VitalSign getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSign vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public boolean recordVitalSigns() {
        if (vitalSigns == null) {
            System.out.println("Vital signs are not registered.");
            return false;
        }
        return vitalSigns.isNormal();
    }

    public void saveVitalSignsToCSV() {
        if (vitalSigns != null) {
            vitalSigns.saveToCSV("vitalSigns.csv");
        } else {
            System.out.println("There are no vital signs to register.");
        }
    }

    public void scheduleMedicalAppointment(String day, String month, String specialty, String doctor) {
        Appointment appointment = new Appointment(day, month, specialty, doctor);
        appointment.saveToCSV(this.name);
    }

    public void addCaregiver(String caregiverName, String relationship, String contactNumber) {
        Caregiver caregiver = new Caregiver(caregiverName, relationship, contactNumber);
        caregiver.saveToCSV(this.name);
    }

    public void assignDietPlan(String breakfast, String lunch, String dinner, String snacks) {
        DietPlan dietPlan = new DietPlan(breakfast, lunch, dinner, snacks);
        dietPlan.saveToCSV(this.name);
    }

    public boolean updateMedication(String newMedication) {
        this.currentMedication = newMedication;
        System.out.println("Medication updated to: " + currentMedication);
        return true;
    }

    public void saveToCSV() {
        try (FileWriter writer = new FileWriter("patients.csv", true)) {
            writer.append(name).append(",");
            writer.append(String.valueOf(age)).append(",");
            writer.append(gender).append(",");
            writer.append(previousMedicalConditions).append(",");
            writer.append(currentMedication).append("\n");
        } catch (IOException e) {
            System.out.println("Error writing patient in CSV: " + e.getMessage());
        }
    }

    public void saveAllDataToCSV() {
        saveToCSV();

        if (vitalSigns != null) {
            vitalSigns.saveToCSV("vitalSigns.csv");
        }

        try (FileWriter writer = new FileWriter("medications.csv", true)) {
            writer.append(name).append(",").append(currentMedication).append("\n");
        } catch (IOException e) {
            System.out.println("Error saving medication to CSV: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter("medicalHistory.csv", true)) {
            writer.append(name).append(",").append(previousMedicalConditions).append("\n");
        } catch (IOException e) {
            System.out.println("Error saving medical history to CSV: " + e.getMessage());
        }

        System.out.println("All patient data saved successfully.");
    }

    public void addPhysicalActivity(String activityName, int durationMinutes, String intensity) {
        PhysicalActivity activity = new PhysicalActivity(activityName, durationMinutes, intensity);
        physicalActivities.add(activity);
        String fileName = name + "_activities.csv";
        activity.saveToCSV(fileName);
        System.out.println("Physical activity added and saved to file: " + fileName);
    }

    public void showPhysicalActivities() {
        if (physicalActivities.isEmpty()) {
            System.out.println("No physical activities registered for this patient.");
        } else {
            for (PhysicalActivity activity : physicalActivities) {
                activity.logActivity();
            }
        }
    }

    public void saveHealthReportToCSV() {
        String fileName = name + "_healthReport.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Name,Age,Gender,Previous Conditions,Current Medication,Temperature,Pulse,Blood Pressure\n");

            String temperature = "", pulse = "", bloodPressure = "";
            if (vitalSigns != null) {
                temperature = String.valueOf(vitalSigns.getTemperature());
                pulse = String.valueOf(vitalSigns.getPulse());
                bloodPressure = vitalSigns.getBloodPressureSys() + "/" + vitalSigns.getBloodPressureDias();
            }

            writer.append(name).append(",")
                  .append(String.valueOf(age)).append(",")
                  .append(gender).append(",")
                  .append(previousMedicalConditions).append(",")
                  .append(currentMedication).append(",")
                  .append(temperature).append(",")
                  .append(pulse).append(",")
                  .append(bloodPressure).append("\n");

            if (!physicalActivities.isEmpty()) {
                writer.append("\nPhysical Activities:\n");
                writer.append("Activity Name,Duration (min),Intensity\n");
                for (PhysicalActivity activity : physicalActivities) {
                    writer.append(activity.getActivityName()).append(",");
                    writer.append(String.valueOf(activity.getDurationMinutes())).append(",");
                    writer.append(activity.getIntensity()).append("\n");
                }
            }

            System.out.println("Health report saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing health report CSV: " + e.getMessage());
        }
    }

    // Registrar actividad física con calorías
    public void recordPhysicalActivity(String activityType, int duration, int caloriesBurned) {
        String intensity;
        if (caloriesBurned < 100) {
            intensity = "Low";
        } else if (caloriesBurned < 300) {
            intensity = "Medium";
        } else {
            intensity = "High";
        }

        addPhysicalActivity(activityType, duration, intensity);
    }

    public void saveAllData() {
        saveAllDataToCSV();
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("name", name);
        document.append("age", age);
        document.append("gender", gender);
        document.append("previousMedicalConditions", previousMedicalConditions);
        document.append("currentMedication", currentMedication);

        if (vitalSigns != null) {
            Document vitalSignsDoc = new Document();
            vitalSignsDoc.append("temperature", vitalSigns.getTemperature());
            vitalSignsDoc.append("pulse", vitalSigns.getPulse());
            vitalSignsDoc.append("bloodPressureSys", vitalSigns.getBloodPressureSys());
            vitalSignsDoc.append("bloodPressureDias", vitalSigns.getBloodPressureDias());
            document.append("vitalSigns", vitalSignsDoc);
        }

        return document;
    }

    public void saveToMongoDB() {
    try {
        MongoDBDataManager manager = new MongoDBDataManager();
        manager.insertPatientDocument(this.toDocument());
    } catch (Exception e) {
        System.err.println("❌ Error guardando paciente en MongoDB: " + e.getMessage());
        e.printStackTrace();
    }
  }
}
