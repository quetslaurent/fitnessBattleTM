package model.inputDataModel;


import java.text.SimpleDateFormat;
import java.util.Calendar;

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


    public static  String getTimeNow(){
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

}