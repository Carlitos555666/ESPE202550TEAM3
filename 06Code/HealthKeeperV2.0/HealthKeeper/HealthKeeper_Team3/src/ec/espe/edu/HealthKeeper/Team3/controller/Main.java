package ec.espe.edu.HealthKeeper.Team3.controller;

import ec.espe.edu.HealthKeeper.Team3.view.LoginFrame; 
import ec.espe.edu.HealthKeeper.Team3.model.MongoDBDataManager; 

import javax.swing.JOptionPane; 

/**
 *
 * @author Team 3
 */
public class Main {
    
    public static MongoDBDataManager mongoDataManager;

    public static void main(String[] args) {
        
        mongoDataManager = new MongoDBDataManager();

        
        try {
            
            if (mongoDataManager.getCollection("testConnection") == null) {
                JOptionPane.showMessageDialog(null, 
                    "Error crítico: No se pudo establecer conexión con MongoDB. La aplicación se cerrará.", 
                    "Error de Conexión a la Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
                System.exit(1); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al verificar la conexión a MongoDB: " + e.getMessage() + ". La aplicación se cerrará.", 
                "Error de Verificación", 
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true); 
            }
        });

    }
}
