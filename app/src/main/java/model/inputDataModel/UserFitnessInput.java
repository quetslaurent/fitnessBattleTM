package model.inputDataModel;

import model.UserFitness;
/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'un Training sera creer.
 *
 *un user possede un email
 * un user posse un role
 *
 * il herite egalement de la classe USERfitness pour le nom et le mdp
 *
 */
public class UserFitnessInput extends UserFitness {
    private int id;
    private String email;
    private String role;

    public UserFitnessInput(String name, String password, String email, String role) {
        super(name, password);
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + role +
                '}';
    }

    public String getAdmin() {
        return role;
    }

    public void setAdmin(String  role) {
        this.role = role;
    }


}
