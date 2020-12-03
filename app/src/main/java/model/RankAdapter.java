package model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.projet.R;
import java.util.List;
import model.outputDataModel.UserFitnessOutput;

public class RankAdapter extends ArrayAdapter<UserFitnessOutput> {

    public RankAdapter(@NonNull Context context, int resource, @NonNull List<UserFitnessOutput> objects){
        super(context,resource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View inflatedView = convertView;

        if(inflatedView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            inflatedView = layoutInflater.inflate(R.layout.list_users_ranking,parent,false);
        }

        final UserFitnessOutput userFitnessOutput = getItem(position);
        populateView(inflatedView,userFitnessOutput);
        return  inflatedView;

    }

    private void populateView(View inflatedView, UserFitnessOutput userFitnessOutput) {
        TextView tvName = inflatedView.findViewById(R.id.list_item_users_name);
        tvName.setText(userFitnessOutput.getName());
        TextView tvPoints = inflatedView.findViewById(R.id.list_item_users_points);
        double user=userFitnessOutput.getPoints();
        String userPoints =""+user;
        tvPoints.setText(userPoints);

    }

}
