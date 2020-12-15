package model.outputDataModel;

/**
 * La classe qui recoit l'objet UserFitnessOutputLogin du serveur
 */

public class UserFitnessOutputLogin {

    private String token;

    public UserFitnessOutputLogin() {
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "UserFitnessOutputLogin{" +
                ", token='" + token + '\'' +
                '}';
    }
}
