package model;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivities extends Category{

    private List<ActivitySport> activities ;

    public CategoryActivities(int id, String name, List activities) {
        super(id, name);
        this.activities =activities;
        /*activitySports = new ArrayList<>();
        activitySports.addAll(activitySports);*/
    }

    /*public void addActivities(ActivitySport activities){
        activitySports.add(activities);
    }*/


    public List<ActivitySport> getActivitySports() {
        return activities;
    }

    public void setActivitySports(List<ActivitySport> activitySports) {
        this.activities = activitySports;
    }

    @Override
    public String toString() {
        return super.toString()+"CategoryActivities{" +
                "activitySports=" + activities +
                '}';
    }
}
