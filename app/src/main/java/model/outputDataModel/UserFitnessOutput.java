package model.outputDataModel;

public class UserFitnessOutput {
    private int id;
    private String name;
    private String password;
    private String email;
    private String role;
    private double points;

    /**
     * La classe qui recoit l'objet UserFitnessOutput du serveur
     */


    public UserFitnessOutput(){
    }

    @Override
    public String toString() {
        return "UserFitnessOutput{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + role +
                ", points=" + points +
                '}';
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

    public double getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof UserFitnessOutput)){
            return false;
        }
        UserFitnessOutput u = (UserFitnessOutput)o;
        return name.equals(u.name) && email.equals(u.email);
    }


}
