package ec.espe.edu.HealthKeeper.Team3.model;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBDataManager {
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    private final String CONNECTION_STRING = System.getenv("MONGODB_URI") != null
            ? System.getenv("MONGODB_URI")
            : "mongodb+srv://mlquiroz:<Mlqh2006>@cluster0.vpeg1ly.mongodb.net/";

    private final String DATABASE_NAME = "HealthKeeperDB";

    public MongoDBDataManager() {
        if (mongoClient == null) {
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                    .serverApi(serverApi)
                    .build();
            try {
                mongoClient = MongoClients.create(settings);
                database = mongoClient.getDatabase(DATABASE_NAME);
                System.out.println("✅ Conexión a MongoDB Atlas establecida.");
            } catch (Exception e) {
                System.err.println("❌ Error al conectar a MongoDB Atlas: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        if (database == null) {
            System.err.println("⚠️ La base de datos no está inicializada. Intentando reconectar...");
            new MongoDBDataManager();
            if (database == null) {
                return null;
            }
        }
        return database.getCollection(collectionName);
    }

    public void insertPatientDocument(Document document) {
        try {
            MongoCollection<Document> collection = getCollection("patients");
            if (collection != null) {
                collection.insertOne(document);
                System.out.println(" Documento del paciente insertado en MongoDB.");
            }
        } catch (Exception e) {
            System.err.println(" Error al insertar paciente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertAppointmentDocument(Document document) {
        try {
            MongoCollection<Document> collection = getCollection("appointments");
            if (collection != null) {
                collection.insertOne(document);
                System.out.println(" Documento de cita insertado en MongoDB.");
            }
        } catch (Exception e) {
            System.err.println(" Error al insertar cita: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertCaregiverDocument(Document document) {
        try {
            MongoCollection<Document> collection = getCollection("caregivers");
            if (collection != null) {
                collection.insertOne(document);
                System.out.println(" Documento de cuidador insertado en MongoDB.");
            }
        } catch (Exception e) {
            System.err.println(" Error al insertar cuidador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
            System.out.println(" Conexión a MongoDB Atlas cerrada.");
        }
    }
}
