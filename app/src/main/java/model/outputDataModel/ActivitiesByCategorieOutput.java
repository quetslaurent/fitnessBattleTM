package model.outputDataModel;

import java.util.List;

import model.outputDataModel.ActivitySport;
import model.outputDataModel.CategoryOutput;

/**
 * La classe qui recoit l'objet CategoryOutput du serveur
 */
public class ActivitiesByCategorieOutput extends CategoryOutput {

    private List<ActivitySport> activities ;

    public ActivitiesByCategorieOutput(int id, String name, List activities) {
        super(id, name);
        this.activities =activities;

    }

    @Override
    public String toString() {
        return super.toString()+"CategoryActivities{" +
                "activitySports=" + activities +
                '}';
    }

    public List<ActivitySport> getActivities() {
        return activities;
    }

}
