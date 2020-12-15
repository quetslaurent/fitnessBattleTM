package model.outputDataModel;

/**
 * La classe qui recoit l'objet UnitOutput du serveur
 */

public class UnitOutput {
    private int id;
    private String type;


    public UnitOutput() {

    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
