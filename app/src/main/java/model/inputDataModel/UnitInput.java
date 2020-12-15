package model.inputDataModel;


/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'un Unit  sera creer.

 *
 */

public class UnitInput {
    private int id;
    private String type;


    public UnitInput(int id, String type) {
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
