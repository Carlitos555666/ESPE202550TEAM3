package ec.espe.edu.HealthKeeper.Team3.view;


import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

 
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Constructor que inicializa los componentes del menú.
     */
    public MenuFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        principalMenu = new javax.swing.JMenu();
        menuItemRegisterPatient = new javax.swing.JMenuItem();
        menuItemAddCaregiver = new javax.swing.JMenuItem();
        menuItemAppointmentSchedule = new javax.swing.JMenuItem();
        menuItemAddDietPlan = new javax.swing.JMenuItem();
        menuItemUpdateMedication = new javax.swing.JMenuItem();
        menuItemRegisterVitalSign = new javax.swing.JMenuItem();
        menuItemRecordPhysicalActivity = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalMenu.setText("Menu");

        menuItemRegisterPatient.setText("Register patient");
        menuItemRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegisterPatientActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemRegisterPatient);

        menuItemAddCaregiver.setText("Add caregiver");
        menuItemAddCaregiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddCaregiverActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemAddCaregiver);

        menuItemAppointmentSchedule.setText("Appointment schedule");
        menuItemAppointmentSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAppointmentScheduleActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemAppointmentSchedule);

        menuItemAddDietPlan.setText("Add diet plan");
        menuItemAddDietPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddDietPlanActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemAddDietPlan);

        menuItemUpdateMedication.setText("Update medication");
        menuItemUpdateMedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUpdateMedicationActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemUpdateMedication);

        menuItemRegisterVitalSign.setText("Register vital signs");
        menuItemRegisterVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegisterVitalSignActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemRegisterVitalSign);

        menuItemRecordPhysicalActivity.setText("Record physical activity");
        menuItemRecordPhysicalActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRecordPhysicalActivityActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemRecordPhysicalActivity);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        principalMenu.add(menuItemExit);

        jMenuBar1.add(principalMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegisterPatientActionPerformed
        new PatientRegistrationFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemRegisterPatientActionPerformed

    private void menuItemAddCaregiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddCaregiverActionPerformed
        new CaregiverRegistrationFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemAddCaregiverActionPerformed

    private void menuItemAppointmentScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAppointmentScheduleActionPerformed
        new AppointmentSchedulingFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemAppointmentScheduleActionPerformed

    private void menuItemAddDietPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddDietPlanActionPerformed
        new DietPlanAssignmentFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemAddDietPlanActionPerformed

    private void menuItemUpdateMedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUpdateMedicationActionPerformed
        new MedicationUpdateFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemUpdateMedicationActionPerformed

    private void menuItemRegisterVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegisterVitalSignActionPerformed
        // Hide the current menu frame
        VitalSignsRecordingFrame vitalSignsFrame = new VitalSignsRecordingFrame(this);
        vitalSignsFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemRegisterVitalSignActionPerformed

    private void menuItemRecordPhysicalActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRecordPhysicalActivityActionPerformed
        new PhysicalActivityRecordingFrame(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuItemRecordPhysicalActivityActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Dou you want exit?", 
                                                    "Confirm to exit", 
                                                    JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_menuItemExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Configura el aspecto visual Nimbus, si está disponible
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Muestra la ventana del menú
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemAddCaregiver;
    private javax.swing.JMenuItem menuItemAddDietPlan;
    private javax.swing.JMenuItem menuItemAppointmentSchedule;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemRecordPhysicalActivity;
    private javax.swing.JMenuItem menuItemRegisterPatient;
    private javax.swing.JMenuItem menuItemRegisterVitalSign;
    private javax.swing.JMenuItem menuItemUpdateMedication;
    private javax.swing.JMenu principalMenu;
    // End of variables declaration//GEN-END:variables
}
