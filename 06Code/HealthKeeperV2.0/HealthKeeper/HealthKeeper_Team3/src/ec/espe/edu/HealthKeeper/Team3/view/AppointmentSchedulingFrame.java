package ec.espe.edu.HealthKeeper.Team3.view;

import ec.espe.edu.HealthKeeper.Team3.model.Appointment;
import ec.espe.edu.HealthKeeper.Team3.controller.Main;
import ec.espe.edu.HealthKeeper.Team3.model.MongoDBDataManager;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class AppointmentSchedulingFrame extends javax.swing.JFrame {

    private MenuFrame parentMenuFrame;

    public AppointmentSchedulingFrame(MenuFrame parentFrame) {
        this.parentMenuFrame = parentFrame;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Appointment Scheduling");
        initializeFields();
    }

    public AppointmentSchedulingFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Appointment Scheduling");
        initializeFields();
    }

    private void initializeFields() {
        Calendar cal = Calendar.getInstance();
        spnDay.setValue(cal.get(Calendar.DAY_OF_MONTH));
        spnMonth.setValue(cal.get(Calendar.MONTH) + 1);
        spnYear.setValue(cal.get(Calendar.YEAR));
        
        // Configurar valores mínimos/máximos para los spinners
        spnDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        spnMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        spnYear.setModel(new javax.swing.SpinnerNumberModel(2023, 2023, 2030, 1));
        
        // Cargar especialidades médicas
        cmbSpecialty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Select Specialty", "Cardiology", "Dermatology", "Neurology", 
            "Pediatrics", "General Medicine", "Ophthalmology", "Orthopedics",
            "Gynecology", "Psychiatry", "Endocrinology"
        }));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDay = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblSpeciality = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        spnDay = new javax.swing.JSpinner();
        spnMonth = new javax.swing.JSpinner();
        spnYear = new javax.swing.JSpinner();
        lblYear = new javax.swing.JLabel();
        cmbSpecialty = new javax.swing.JComboBox<>();
        txtDoctor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnSchedule = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Medical appointment");

        lblDay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDay.setText("Day:");

        lblMonth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMonth.setText("Month:");

        lblSpeciality.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSpeciality.setText("Speciality:");

        lblDoctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoctor.setText("Doctor:");

        lblYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblYear.setText("Year");

        cmbSpecialty.setBackground(new java.awt.Color(255, 255, 255));
        cmbSpecialty.setForeground(new java.awt.Color(0, 0, 0));
        cmbSpecialty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Specialty", "Cardiology", "Dermatology", "Neurology", "Pediatrics", "General Medicine", "Ophthalmology" }));

        txtDoctor.setBackground(new java.awt.Color(255, 255, 255));
        txtDoctor.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(spnYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDoctor)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblDay)
                                .addGap(56, 56, 56)
                                .addComponent(spnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDay, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonth))
                    .addComponent(spnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYear))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpeciality)
                    .addComponent(cmbSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctor)
                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnSchedule.setBackground(new java.awt.Color(51, 204, 0));
        btnSchedule.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSchedule.setForeground(new java.awt.Color(0, 0, 0));
        btnSchedule.setText("Schedule appointment");

        btnBack.setBackground(new java.awt.Color(153, 102, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back to menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSchedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSchedule)
                    .addComponent(btnBack))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose(); // Closes the current window or frame.
        if (parentMenuFrame != null) { // Checks if a reference to the parent menu frame exists.
            parentMenuFrame.setVisible(true); // If it exists, makes that parent menu frame visible again.
        } else {
            new MenuFrame().setVisible(true); // If no parent reference, creates a *new* MenuFrame and makes it visible.
        }
    }//GEN-LAST:event_btnBackActionPerformed
    
    
    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int day = (Integer) spnDay.getValue();
            int month = (Integer) spnMonth.getValue();
            int year = (Integer) spnYear.getValue();
            String specialty = (String) cmbSpecialty.getSelectedItem();
            String doctor = txtDoctor.getText().trim();

            // Validaciones
            if (specialty.equals("Select Specialty")) {
                JOptionPane.showMessageDialog(this, "Please select a specialty", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (doctor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the doctor's name", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidDate(day, month, year)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date", 
                    "Date Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear la cita
            Appointment appointment = new Appointment(
                String.valueOf(day), 
                String.valueOf(month), 
                String.valueOf(year), 
                specialty, 
                doctor
            );
            
            // Guardar en MongoDB
            appointment.saveToMongoDB();
            
            // Opcional: Guardar también en CSV
            appointment.saveToCSV("Current Patient"); // Deberías obtener el nombre real del paciente

            // Mostrar confirmación
            JOptionPane.showMessageDialog(this, 
                "Appointment scheduled successfully!\n" +
                "Date: " + day + "/" + month + "/" + year + "\n" +
                "Specialty: " + specialty + "\n" +
                "Doctor: " + doctor,
                "Success", JOptionPane.INFORMATION_MESSAGE);

            // Resetear campos
            initializeFields();
            cmbSpecialty.setSelectedIndex(0);
            txtDoctor.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for date fields", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error scheduling appointment: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.set(year, month - 1, day); // Month is 0-based in Calendar
            cal.getTime(); // Will throw exception if invalid
            
            // Verificar que la fecha no sea en el pasado
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            
            return !cal.before(today);
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentSchedulingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Main.mongoDataManager = new MongoDBDataManager();
            new AppointmentSchedulingFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JComboBox<String> cmbSpecialty;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblSpeciality;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblYear;
    private javax.swing.JSpinner spnDay;
    private javax.swing.JSpinner spnMonth;
    private javax.swing.JSpinner spnYear;
    private javax.swing.JTextField txtDoctor;
    // End of variables declaration//GEN-END:variables
}
