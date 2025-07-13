package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VitalSign {
    private float temperature;
    private int pulse;
    private int bloodPressureSys;
    private int bloodPressureDias;

    public VitalSign(float temperature, int pulse, int bloodPressureSys, int bloodPressureDias) {
        this.temperature = temperature;
        this.pulse = pulse;
        this.bloodPressureSys = bloodPressureSys;
        this.bloodPressureDias = bloodPressureDias;
    }

    public VitalSign(double temperature, int pulse, int bloodPressure) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean isNormal() {
        boolean tempNormal = temperature >= 36.0 && temperature <= 37.5;
        boolean pulseNormal = pulse >= 60 && pulse <= 100;
        boolean pressureNormalSys = bloodPressureSys >= 80 && bloodPressureSys <= 120;
        boolean pressureNormalDias = bloodPressureDias >= 60 && bloodPressureDias <= 80;


        return tempNormal && pulseNormal && pressureNormalSys && pressureNormalDias;
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(temperature + "," + pulse + "," + bloodPressureSys + "," + bloodPressureDias);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing vital signs to file: " + e.getMessage());
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getBloodPressureSys() {
        return bloodPressureSys;
    }
    
    public int getBloodPressureDias() {
        return bloodPressureDias;
    }

    public void setBloodPressureSys(int bloodPressureSys) {
        this.bloodPressureSys = bloodPressureSys;
    }
    
    public void setBloodPressureDias(int bloodPressureDias) {
        this.bloodPressureDias = bloodPressureDias;
    }
}
