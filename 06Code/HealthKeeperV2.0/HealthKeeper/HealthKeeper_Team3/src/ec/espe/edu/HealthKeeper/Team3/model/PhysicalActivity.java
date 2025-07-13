package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PhysicalActivity {
    private String activityName;
    private int durationMinutes;
    private String intensity; 

    public PhysicalActivity(String activityName, int durationMinutes, String intensity) {
        this.activityName = activityName;
        this.durationMinutes = durationMinutes;
        this.intensity = intensity;
    }

    public void logActivity() {
        System.out.println("Physical activity registered:");
        System.out.println("Activity: " + activityName);
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Intensity: " + intensity);
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(activityName + "," + durationMinutes + "," + intensity);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing physical activity to file: " + e.getMessage());
        }
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
