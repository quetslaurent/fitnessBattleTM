package model.inputDataModel;

import model.UserFitness;

public class UserFitnessInput extends UserFitness {
    private int id;
    private String email;
    private Boolean admin;

    public UserFitnessInput(String name, String password, String email, Boolean admin) {
        super(name, password);
        this.email = email;
        this.admin = admin;
        this.admin=admin;
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
                ", admin=" + admin +
                '}';
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }


}
