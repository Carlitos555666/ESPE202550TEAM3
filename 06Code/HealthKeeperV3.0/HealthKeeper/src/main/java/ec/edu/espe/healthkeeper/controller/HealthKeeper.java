package ec.edu.espe.healthkeeper.controller;

import ec.edu.espe.healthkeeper.utils.MongoDBConnection;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class HealthKeeper {
    public static void main(String[] args) {
        System.out.println("Starting HealthKeeper...");

        // 1) Conectar a MongoDB (usa el singleton)
        MongoDBConnection conn = MongoDBConnection.getInstance();
        boolean ok = conn.connect();

        if (!ok) {
            // mostrar error y salir
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la base de datos MongoDB.\nRevise la configuración.",
                    "Error de conexión",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Registramos hook para cerrar la conexión al terminar
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing MongoDB connection...");
            conn.close();
        }));

        // 2) Continuar ejecución de la app (ejemplo mínimo: mensaje)
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null,
                    "Conectado a MongoDB correctamente. Puedes continuar con la app.",
                    "Conexión OK",
                    JOptionPane.INFORMATION_MESSAGE);
            // aquí abrirías tu LoginFrame o Dashboard
        });
    }
}
