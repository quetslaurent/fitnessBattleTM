package com.example.projet;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;

import model.ActivitySport;


public class ListActivitySport extends ListActivity implements OnItemClickListener {

    private List<ActivitySport> activities;
    private ArrayList<ActivitySport> activitySelected;
    private static String EXTRA_SPORT_SELECTED = "EXTRA_SPORT_SELECTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_activity);

        activitySelected = getIntent().getParcelableArrayListExtra(EXTRA_SPORT_SELECTED); //on récupère la list envoyée depuis AddActivity
        activities = createActivity(activitySelected);

        setListAdapter(new ListActivityAdapter(this, R.layout.item_list, activities));
        getListView().setOnItemClickListener(this);
    }

    /**
     *
     * @param activitiesSelected , liste des activités selectionner
     * @return
     */
    private List<ActivitySport> createActivity(List<ActivitySport>activitiesSelected){
        List<ActivitySport> activities = new ArrayList<ActivitySport>();

        activities.add(createActivity("Pompes",10));
        activities.add(createActivity("Tractions",10));
        activities.add(createActivity("Courses",10));
        activities.add(createActivity("Abdos",10));

        for(ActivitySport activitySelected:activitiesSelected){
            for(ActivitySport activitySport:activities){
                if(activitiesSelected.equals(activitySport)){
                    activitySport.setChecked(true);
                    break;
                }
            }
        }

        return activities;
    }


    private ActivitySport createActivity(String name, int nbRepetition){
        ActivitySport c = new ActivitySport();
        c.setChecked(false);
        c.setName(name);
        c.setNbrepetitionPoint(nbRepetition);
        return c;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Permet de verifier si la checkbox est coché ou non
     * @param v
     */
    public void checkboxHandler(View v) {
        CheckBox cb = (CheckBox) v;
        // On récupère la position à l'aide du tag défini dans l'adapter ListColorsAdapter
        int position = Integer.parseInt(cb.getTag().toString());

        // On récupère l'élément Color sur lequel on se trouve
        ActivitySport activitySport = (ActivitySport)getListView().getItemAtPosition(position);
        activitySport.setChecked(cb.isChecked());

        addActivitySportSelected(activitySport);
    }

    /**
     * il va ajouter dans la liste des élements sélectionner pour la retourner dans la view suivante
     * @param activitySport
     */
    private void addActivitySportSelected(ActivitySport activitySport){
        if(activitySelected.contains(activitySport) && !activitySport.isChecked()){
            activitySelected.remove(activitySport);
        }else if(!activitySelected.contains(activitySport) && activitySport.isChecked()){
            activitySelected.add(activitySport);
        }
    }

    /**
     * Renvoie a la vue precedente la liste des activities selectionner
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(EXTRA_SPORT_SELECTED,activitySelected);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
