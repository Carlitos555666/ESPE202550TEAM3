package ec.espe.edu.HealthKeeper.Team3.model;
/**
 *
 * @author Team 3: Pailacho Carlos, Palacios Daniel, Quiroz Maria
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserAccount {
    private String username;
    private String password;
    private String email;

    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public void displayAccountInfo() {
        System.out.println("User Account Information:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }

    public void saveToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(username + "," + password + "," + email);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing user account to file: " + e.getMessage());
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
