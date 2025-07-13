package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Notification {
    private String title;
    private String message;

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public void send() {
        System.out.println("---- Notification ----");
        System.out.println("Title: " + title);
        System.out.println("Message: " + message);
        System.out.println("----------------------");
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(title + "," + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing notification to file: " + e.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
