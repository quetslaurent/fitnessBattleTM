package model.outputDataModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La classe qui recoit l'objet TrainingOutput du serveur
 */
public class TrainingOutput {

   private int id;
    private double points;
    private double repetitions;
    private String trainingDateValue;
    private String activityName;


    public TrainingOutput(){

    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", point=" + points +
                ", repetition=" + repetitions +
                ", date='" + trainingDateValue + '\'' +
                ", activityName='" + activityName + '\'' +
                '}';
    }

 public int getId() {
  return id;
 }

 public double getPoints() {
  return points;
 }

 public double getRepetitions() {
  return repetitions;
 }

 public String getTrainingDateValue() throws ParseException {
  DateFormat output = new SimpleDateFormat("dd-MM-yyyy ' à 'HH:mm:ss");
  DateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
  Date date = input.parse(trainingDateValue);
  String formattedDate = output.format(date);
  return formattedDate;
 }

 public String getActivityName() {
  return activityName;
 }
}
