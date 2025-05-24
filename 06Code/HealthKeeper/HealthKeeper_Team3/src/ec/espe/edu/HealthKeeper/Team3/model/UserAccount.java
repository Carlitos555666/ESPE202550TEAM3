package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Team 3
 */

public class UserAccount {
    private String username;
    private String password;
    private String role;

    public UserAccount(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login() {
        System.out.println("Inicio de sesión correcto: " + username);
        return true;
    }

    public boolean logout() {
        System.out.println("Cierre de sesión exitoso: " + username);
        return true;
    }
}