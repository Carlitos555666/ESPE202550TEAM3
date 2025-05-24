package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */
public class MedicalHistory {
    private String illness;
    private String allergies;
    private String additionalNotes;

    public MedicalHistory(String illness, String allergies, String additionalNotes) {
        this.illness = illness;
        this.allergies = allergies;
        this.additionalNotes = additionalNotes;
    }

    public boolean addRegister() {
        System.out.println("Historial médico actualizado.");
        return true;
    }
    
    public void viewHistory() {
    System.out.println("Alergias: " + allergies);
    System.out.println("Enfermedades: " + illnesses);
    System.out.println("Medicamentos: " + medications);
    System.out.println("Dieta: " + diet);
    }

}
