package modele.outputDataModel;

public class UnitOutput {
    private int id;
    private String type;


    public UnitOutput(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
