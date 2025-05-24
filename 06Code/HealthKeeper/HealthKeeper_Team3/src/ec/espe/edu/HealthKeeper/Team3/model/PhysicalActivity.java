package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
public class PhysicalActivity {
    private String activityType;
    private int duration;
    private String intensity;

    public PhysicalActivity(String activityType, int duration, String intensity) {
        this.activityType = activityType;
        this.duration = duration;
        this.intensity = intensity;
    }

    public boolean registerActivity() {
        System.out.println("Actividad registrada: " + activityType);
        return true;
    }
}

