package model.Adapter;

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

    //constructeur
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
        populateView(inflatedView,userFitnessOutput, position);
        return  inflatedView;

    }

    //afficher dans la listeview
    private void populateView(View inflatedView, UserFitnessOutput userFitnessOutput,int position) {
        TextView tvName = inflatedView.findViewById(R.id.list_item_users_name);
        tvName.setText(userFitnessOutput.getName());
        TextView tvPoints = inflatedView.findViewById(R.id.list_item_users_points);
        double user=userFitnessOutput.getPoints();

        double d = (double) Math.round(user * 100) / 100;
        String pointUser = d+" Points";

        tvPoints.setText(pointUser);
        TextView tvPosition = inflatedView.findViewById(R.id.position);
        position = position+1;
        String pos = ""+position;
        tvPosition.setText(pos);

    }

}
