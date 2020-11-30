package model.outputDataModel;

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

 public String getTrainingDateValue() {
  return trainingDateValue;
 }

 public String getActivityName() {
  return activityName;
 }
}
