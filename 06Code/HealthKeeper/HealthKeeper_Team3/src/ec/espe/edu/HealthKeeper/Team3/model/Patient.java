package ec.espe.edu.HealthKeeper.Team3.model;

public class Patient {
    private String name;
    private int age;
    private String gender;
    private String previousMedicalConditions;
    private String currentMedication;
    private VitalSign vitalSigns;

    public Patient(String name, int age, String gender, String previousMedicalConditions, String currentMedication, VitalSign vitalSigns) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.previousMedicalConditions = previousMedicalConditions;
        this.currentMedication = currentMedication;
        this.vitalSigns = vitalSigns;
    }

    public String getName() {
        return name;
    }

    public boolean recordVitalSigns() {
    if (vitalSigns == null) {
        System.out.println("No se han registrado signos vitales.");
        return false;
    }
    return vitalSigns.validateValues();
    }


    public boolean scheduleMedicalAppointment(String day, String month, String specialty, String doctor) {
    Appointment appointment = new Appointment(day, month, specialty, doctor);
    System.out.println(appointment);
    return true;
    }


    public boolean updateMedication(String newMedication) {
    this.currentMedication = newMedication;
    System.out.println("Medicacion actualizada a: " + currentMedication);
    return true;
    }
    
    public void setVitalSigns(VitalSign vitalSigns) {
    this.vitalSigns = vitalSigns;
    }

}