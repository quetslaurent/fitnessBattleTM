package model;

import android.app.Activity;

public class Training {

    private int id;
    private User user;
    private ActivitySport activitySport;
    private double repeition;
    private TrainingDate trainingDate;

    public Training(int id, User user, ActivitySport activitySport, double repeition, TrainingDate trainingDate) {
        this.id = id;
        this.user = user;
        this.activitySport = activitySport;
        this.repeition = repeition;
        this.trainingDate = trainingDate;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", user=" + user +
                ", activitySport=" + activitySport +
                ", repeition=" + repeition +
                ", trainingDate=" + trainingDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActivitySport getActivitySport() {
        return activitySport;
    }

    public void setActivitySport(ActivitySport activitySport) {
        this.activitySport = activitySport;
    }

    public double getRepeition() {
        return repeition;
    }

    public void setRepeition(double repeition) {
        this.repeition = repeition;
    }

    public TrainingDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(TrainingDate trainingDate) {
        this.trainingDate = trainingDate;
    }
}
