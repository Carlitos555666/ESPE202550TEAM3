package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
import java.time.LocalDateTime;

public class EmergencyAlert {
    private String alertType;
    private String triggeredBy;
    private LocalDateTime timeStamp;

    public EmergencyAlert(String alertType, String triggeredBy, LocalDateTime timeStamp) {
        this.alertType = alertType;
        this.triggeredBy = triggeredBy;
        this.timeStamp = timeStamp;
    }

    public boolean sendEmergencyAlert() {
        System.out.println("¡Emergencia enviada por: " + triggeredBy);
        return true;
    }
}
