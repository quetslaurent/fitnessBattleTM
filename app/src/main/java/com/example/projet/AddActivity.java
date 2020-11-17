package com.example.projet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.ActivitySport;

public class AddActivity extends Activity implements OnClickListener {

    //private final List<Activity> activities = new ArrayList<>();
    private static int REQUEST_CODE = 1;
    private TextView infosActivitySelected;
    private Context context;
    private Button button;
    private ArrayList<ActivitySport> activitySportArrayListSelected;

    private static String EXTRA_SPORT_SELECTED ="EXTRA_SPORT_SELECTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        context = this;
        activitySportArrayListSelected = new ArrayList<ActivitySport>();
        infosActivitySelected = (TextView) findViewById(R.id.textInfos);
        button = (Button) findViewById(R.id.btnChooseActivity);
        button.setOnClickListener(this);
    }

     @Override
    public void onClick(View paramView) {
        Intent intent = new Intent(context, ListActivitySport.class);
        startActivityForResult(intent, REQUEST_CODE);
    }



   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
// On construit le message à afficher suivant les couleurs sélectionnées
            activitySportArrayListSelected = data.getParcelableArrayListExtra(EXTRA_SPORT_SELECTED);
            if(activitySportArrayListSelected.isEmpty()){
                infosActivitySelected.setText("Aucun sport n'a été selectionner");
            }else{
                StringBuffer buffer = new StringBuffer();
                for(int i = 0; i < activitySportArrayListSelected.size(); i++){
                    if(i != 0){
                        buffer.append(", ");
                    }
                    buffer.append(activitySportArrayListSelected.get(i).getName());
                }
                infosActivitySelected.setText(String.format(getResources().getString(R.string.activitySportArraySelected), buffer));
            }
        }
        }
    }


