package model;

public class Training {

    private int id;
    private UserFitness user;
    private ActivitySport activitySport;
    private double repetition;
    private TrainingDate trainingDate;

    public Training(int id, UserFitness user, ActivitySport activitySport, double repetition, TrainingDate trainingDate) {
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
                ", repeition=" + repetition +
                ", trainingDate=" + trainingDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

    public ActivitySport getActivitySport() {
        return activitySport;
    }

    public void setActivitySport(ActivitySport activitySport) {
        this.activitySport = activitySport;
    }

    public double getRepeition() {
        return repetition;
    }

    public void setRepeition(double repeition) {
        this.repetition = repeition;
    }

    public TrainingDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(TrainingDate trainingDate) {
        this.trainingDate = trainingDate;
    }
}
