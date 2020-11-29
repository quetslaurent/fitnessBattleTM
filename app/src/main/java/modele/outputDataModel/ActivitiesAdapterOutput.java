package modele.outputDataModel;

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

public class ActivitiesAdapterOutput extends ArrayAdapter<ActivitySport> {

    public ActivitiesAdapterOutput(@NonNull Context context, int resource, @NonNull List<ActivitySport> objects){
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

        final ActivitySport activitySport = getItem(position);
        populateView(inflatedView,activitySport);
        return  inflatedView;

    }

    private void populateView(View inflatedView, ActivitySport activitySport) {
        TextView tvName = inflatedView.findViewById(R.id.list_item_activities_name);
        tvName.setText(activitySport.getName());

    }


}
