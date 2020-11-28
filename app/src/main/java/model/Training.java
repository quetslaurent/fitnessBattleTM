package model;

public class Training {

    private int id;
   /* private UserFitness user;
    private ActivitySport activitySport;
    private double repetition;
    private TrainingDate trainingDate; */
   private double repetition;
    private int userId;
    private int ActivitySportid;
    private int trainingDateId;
    private double point;

    public Training(double repetition, int userId, int activitySportid, int trainingDateId,double point) {

        this.userId = userId;
        ActivitySportid = activitySportid;
        this.repetition = repetition;
        this.trainingDateId = trainingDateId;
        this.point = point;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivitySportid() {
        return ActivitySportid;
    }

    public void setActivitySportid(int activitySportid) {
        ActivitySportid = activitySportid;
    }

    public double getRepetition() {
        return repetition;
    }

    public void setRepetition(double repetition) {
        this.repetition = repetition;
    }

    public int getTrainingDateId() {
        return trainingDateId;
    }

    public void setTrainingDateId(int trainingDateId) {
        this.trainingDateId = trainingDateId;
    }
    /* public Training(int id, UserFitness user, ActivitySport activitySport, double repetition, TrainingDate trainingDate) {
        this.id = id;
        this.user = user;
        this.activitySport = activitySport;
        this.repetition = repetition;
        this.trainingDate = trainingDate;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", user=" + user +
                ", activitySport=" + activitySport +
                ", repetition=" + repetition +
                ", trainingDate=" + trainingDate +
                '}';
    } */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
