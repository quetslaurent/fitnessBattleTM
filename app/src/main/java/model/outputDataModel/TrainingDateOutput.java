package model.outputDataModel;


import java.util.Date;


/**
 * La classe qui recoit l'objet TrainingDateOutput du serveur
 */
public class TrainingDateOutput {

    private int id;
    private Date date;


    public TrainingDateOutput(){
    }


    @Override
    public String toString() {
        return "TrainingDate{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }




}
