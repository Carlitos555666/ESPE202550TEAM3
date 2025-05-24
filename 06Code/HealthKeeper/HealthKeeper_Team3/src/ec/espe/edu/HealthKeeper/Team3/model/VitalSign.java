
package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */

public class VitalSign {
    private float temperature;
    private int pulse;
    private int bloodPressure;

    public VitalSign(float temperature, int pulse, int bloodPressure) {
        this.temperature = temperature;
        this.pulse = pulse;
        this.bloodPressure = bloodPressure;
    }

    public boolean validateValues() {
        return temperature >= 35 && temperature <= 37
            && pulse >= 60 && pulse <= 120
            && bloodPressure >= 90 && bloodPressure <= 140;
    }
    
    public float getTemperature() {
        return temperature;
    }

    public int getPulse() {
        return pulse;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }
}

