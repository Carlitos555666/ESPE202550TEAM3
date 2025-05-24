
package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
public class Appointment {
    private String day;
    private String month;
    private String specialty;
    private String doctor;

    public Appointment(String day, String month, String specialty, String doctor) {
        this.day = day;
        this.month = month;
        this.specialty = specialty;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "\n Cita medica agendada:\n" +
               "Dia: " + day + "\n" +
               "Mes: " + month + "\n" +
               "Especialidad: " + specialty + "\n" +
               "Doctor: " + doctor;
    }
}


