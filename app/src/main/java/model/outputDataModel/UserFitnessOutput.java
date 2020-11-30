package model.outputDataModel;

public class UserFitnessOutput {
    private int id;
    private String name;
    private String password;
    private String email;
    private Boolean admin;
    private double points;

    public UserFitnessOutput(){
    }

    @Override
    public String toString() {
        return "UserFitnessOutput{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
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
