package model;


import java.util.Date;

public class TrainingDate {

    private int id;
    private Date date;


    public TrainingDate(int id, Date date) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
