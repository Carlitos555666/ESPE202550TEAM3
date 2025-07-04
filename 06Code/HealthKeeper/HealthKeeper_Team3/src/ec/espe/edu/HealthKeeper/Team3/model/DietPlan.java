package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.FileWriter;
import java.io.IOException;

public class DietPlan {
    private String breakfast;
    private String lunch;
    private String dinner;
    private String snacks;

    public DietPlan(String breakfast, String lunch, String dinner, String snacks) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snacks = snacks;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public void saveToCSV(String patientName) {
        String fileName = "dietplans.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(patientName).append(",")
                  .append(breakfast).append(",")
                  .append(lunch).append(",")
                  .append(dinner).append(",")
                  .append(snacks).append("\n");
            writer.flush();
            System.out.println("Diet plan saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving diet plan: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "DietPlan{" +
                "breakfast='" + breakfast + '\'' +
                ", lunch='" + lunch + '\'' +
                ", dinner='" + dinner + '\'' +
                ", snacks='" + snacks + '\'' +
                '}';
    }
}