package ec.edu.espe.healthkeeper.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class User {
    private String id; // hex string of ObjectId
    private String username;
    private String passwordHash;
    private String email;
    private String role;

    public User(String id, String username, String passwordHash, String email, String role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Document toDocument() {
        Document doc = new Document()
                .append("username", username)
                .append("passwordHash", passwordHash)
                .append("email", email)
                .append("role", role);
        if (id != null) {
            doc.append("_id", new ObjectId(id));
        }
        return doc;
    }

    public static User fromDocument(Document doc) {
        if (doc == null) return null;
        ObjectId oid = doc.getObjectId("_id");
        String idHex = oid != null ? oid.toHexString() : null;
        return new User(
                idHex,
                doc.getString("username"),
                doc.getString("passwordHash"),
                doc.getString("email"),
                doc.getString("role")
        );
    }
}
