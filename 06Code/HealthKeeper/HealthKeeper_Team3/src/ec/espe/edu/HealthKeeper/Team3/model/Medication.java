
package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
public class Medication {
    private String name;
    private String dose;
    private String frequency;
    private String nextTimeTake;

    public Medication(String name, String dose, String frequency, String nextTimeTake) {
        this.name = name;
        this.dose = dose;
        this.frequency = frequency;
        this.nextTimeTake = nextTimeTake;
    }

    public boolean timeToTake() {
        System.out.println("Es hora de tomar: " + name);
        return true;
    }
}
