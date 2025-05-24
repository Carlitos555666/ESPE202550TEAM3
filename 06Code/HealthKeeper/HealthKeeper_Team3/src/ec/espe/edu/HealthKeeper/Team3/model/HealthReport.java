package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3: Paca, Pailacho, Palacios, Quiroz
 */
public class HealthReport {
    private String reportDate;
    private String summary;
    private int patientID;

    public HealthReport(String reportDate, String summary, int patientID) {
        this.reportDate = reportDate;
        this.summary = summary;
        this.patientID = patientID;
    }

    public boolean generateReport() {
        System.out.println("Reporte generado.");
        return true;
    }
}

