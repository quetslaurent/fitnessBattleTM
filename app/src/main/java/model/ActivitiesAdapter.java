package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projet.R;

import java.util.List;

import model.outputDataModel.ActivitiesByCategorieOutput;
import model.outputDataModel.ActivitySport;

public class ActivitiesAdapter extends ArrayAdapter<ActivitiesByCategorieOutput> {

    public ActivitiesAdapter(@NonNull Context context, int resource, @NonNull List<ActivitiesByCategorieOutput> objects){
        super(context,resource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View inflatedView = convertView;

        if(inflatedView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            inflatedView = layoutInflater.inflate(R.layout.list_item_activity,parent,false);
        }

        final ActivitiesByCategorieOutput activitiesByCategorieOutput = getItem(position);
        populateView(inflatedView,activitiesByCategorieOutput);
        return  inflatedView;

    }

    private void populateView(View inflatedView, ActivitiesByCategorieOutput activitiesByCategorieOutput) {
        TextView tvName = inflatedView.findViewById(R.id.list_item_activities_name);

        List<ActivitySport> activities = activitiesByCategorieOutput.getActivities();
        for(int i=0; i<activities.size();i++){
            String nameActivities = activities.get(i).getName();
            tvName.setText(nameActivities);
        }
    }


}
