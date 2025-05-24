
package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
import java.time.LocalDateTime;

public class Notification {
    private String message;
    private String type;
    private LocalDateTime dateTime;

    public Notification(String message, String type, LocalDateTime dateTime) {
        this.message = message;
        this.type = type;
        this.dateTime = dateTime;
    }

    public boolean sendNotification() {
        System.out.println("Notificación: " + message);
        return true;
    }
}

