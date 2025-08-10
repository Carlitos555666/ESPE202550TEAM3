package ec.edu.espe.healthkeeper.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
    private static MongoDBConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    // **** Cambia aquí la URI o (mejor) carga desde variable de entorno ****
    private static final String CONNECTION_STRING =
        "mongodb+srv://mlquiroz:Mlqh2006@cluster0.vpeg1ly.mongodb.net/?retryWrites=true&w=majority";

    // Nombre de la BD (ajusta si usas otra)
    private static final String DATABASE_NAME = "healthkeeper";

    private MongoDBConnection() { }

    public static synchronized MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }

    /**
     * Intenta crear el cliente y ping a la DB. Devuelve true si OK.
     */
    public boolean connect() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);

            // ping para verificar la conexión (comando simple)
            Document ping = database.runCommand(new Document("ping", 1));
            // si no lanza excepción, asumimos OK
            System.out.println("MongoDB ping response: " + ping.toJson());
            return true;
        } catch (Exception e) {
            System.err.println("Error conectando a MongoDB: " + e.getMessage());
            return false;
        }
    }

    public MongoDatabase getDatabase() {
        if (database == null) {
            throw new IllegalStateException("Not connected to MongoDB. Call connect() first.");
        }
        return database;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
        }
    }
}
