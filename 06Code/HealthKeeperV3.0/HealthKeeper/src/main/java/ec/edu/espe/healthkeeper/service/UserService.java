package ec.edu.espe.healthkeeper.service;

import ec.edu.espe.healthkeeper.model.User;
import ec.edu.espe.healthkeeper.utils.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class UserService {
    private final MongoCollection<Document> usersCollection;

    public UserService() {
        MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
        this.usersCollection = db.getCollection("users");
    }

    public Optional<User> findByUsername(String username) {
        Document doc = usersCollection.find(eq("username", username)).first();
        return doc == null ? Optional.empty() : Optional.of(User.fromDocument(doc));
    }

    public boolean validatePassword(String username, String plainPassword) {
        Optional<User> opt = findByUsername(username);
        if (!opt.isPresent()) return false;
        String hash = opt.get().getPasswordHash();
        return BCrypt.checkpw(plainPassword, hash);
    }

    public User createUser(String username, String plainPassword, String email, String role) {
        String hash = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        User u = new User(null, username, hash, email, role);
        usersCollection.insertOne(u.toDocument());
        // obtener el documento insertado (simple) — devolver usuario sin id o buscarlo luego
        return u;
    }
}
