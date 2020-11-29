package com.example.projet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;
import modele.outputDataModel.ActivitiesAdapterOutput;
import modele.outputDataModel.ActivitySport;
import modele.outputDataModel.Category;
import modele.outputDataModel.UnitOutput;
import repository.ActivityRepository;

public class ListActivitySport extends AppCompatActivity{

    private final List<ActivitySport> activitySports = new ArrayList<>();
    private Category c1 = new Category(1,"Upper Body");
    private UnitOutput u1 = new UnitOutput(1,"Type5");
    private ActivityRepository activityRepository = new ActivityRepository();
    private LiveData<ActivitySport> liveActivity;
    private ListView lvActivities;
    private ActivitiesAdapterOutput activitiesAdapterOutput;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        lvActivities = (ListView)findViewById(R.id.list_activities);
        context = this;

        getActivity().observe(this, new Observer<ActivitySport>() {
            @Override
            public void onChanged(ActivitySport activitySport) {
                Log.i("test",activitySport.toString());
                activitySports.add(activitySport);

                activitiesAdapterOutput = new ActivitiesAdapterOutput(
                        context,
                        R.id.list_activities,
                        activitySports);
                lvActivities.setAdapter(activitiesAdapterOutput);
            }
        });


    }


    public LiveData<ActivitySport> getActivity(){
        return liveActivity = activityRepository.getById(1);
    }

}
