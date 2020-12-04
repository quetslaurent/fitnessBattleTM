package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.projet.R;
import java.util.List;

import model.outputDataModel.ActivitySport;

public class ActivitiesAdapter extends ArrayAdapter<ActivitySport> {


    public ActivitiesAdapter(@NonNull Context context, int resource, @NonNull List<ActivitySport> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View inflatedView = convertView;

        if(inflatedView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            inflatedView = layoutInflater.inflate(R.layout.list_item_activities,parent,false);
        }

        final ActivitySport activitySport = getItem(position);

        populateView(inflatedView, activitySport);
        return  inflatedView;
    }

    private void populateView(View inflatedView, ActivitySport activitySport) {
        String name = activitySport.getName();
        TextView tvName = inflatedView.findViewById(R.id.list_item_activities_name);
        tvName.setText(name);

    }

}
