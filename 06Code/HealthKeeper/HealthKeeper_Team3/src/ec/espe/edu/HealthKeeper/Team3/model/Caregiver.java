package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Maria Quiroz
 */
public class Caregiver {
    private String name;
    private int id;
    private String phone;
    private String email;

    public Caregiver(String name, int id, String phone, String email) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

    public boolean registerPatient(Patient p) {
        System.out.println("Registrando paciente: " + p.getName());
        return true;
    }

    public boolean updatePatientInfo(Patient p) {
        System.out.println("Actualizando información de: " + p.getName());
        return true;
    }

    public void viewMedicalHistory(Patient patient) {
    System.out.println("Historial médico del paciente:");
    patient.getMedicalHistory().viewHistory();
    
    }
}

