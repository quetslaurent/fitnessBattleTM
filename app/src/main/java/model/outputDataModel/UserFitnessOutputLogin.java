package model.outputDataModel;

public class UserFitnessOutputLogin {

    private String token;

    public UserFitnessOutputLogin() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "UserFitnessOutputLogin{" +
                ", token='" + token + '\'' +
                '}';
    }
}
