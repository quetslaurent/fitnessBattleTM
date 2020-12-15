package model.inputDataModel;


import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'une date sera creer.
 */
public class TrainingDateInput {

    private int id;
    private String date;


    public TrainingDateInput(String date) {

        this.date = date;
    }


    @Override
    public String toString() {
        return "TrainingDate{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
