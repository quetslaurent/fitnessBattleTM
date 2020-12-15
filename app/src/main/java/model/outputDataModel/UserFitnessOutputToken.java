package model.outputDataModel;

/**
 * La classe qui recoit l'objet UserFitnessOutputToken du serveur
 */

public class UserFitnessOutputToken {

    private int id;
    private String name;
    private String email;
    private String role;

    public UserFitnessOutputToken() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
}
