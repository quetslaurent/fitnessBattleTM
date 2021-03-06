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

import java.text.ParseException;
import java.util.List;

import model.outputDataModel.TrainingOutput;

public class TrainingAdapter extends ArrayAdapter<TrainingOutput> {

    //constructeur
    public TrainingAdapter(@NonNull Context context, int resource, @NonNull List<TrainingOutput> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View inflatedView = convertView;
        if(inflatedView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            inflatedView=layoutInflater.inflate(R.layout.list_item_training,parent,false);
        }
        final TrainingOutput trainingOutput = getItem(position);
        try {
            populateView(inflatedView,trainingOutput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  inflatedView;
    }

    //afficher dans la listeview
    private void populateView(View inflatedView, TrainingOutput trainingOutput) throws ParseException {
        TextView tvName = inflatedView.findViewById(R.id.tv_list_item_activity_name);
        TextView tvdate = inflatedView.findViewById(R.id.tv_list_item_activity_date);
        TextView tv_rep = inflatedView.findViewById(R.id.tv_list_item_activity_nbRepetition);

        tvName.setText("Activity : " + trainingOutput.getActivityName());
        tv_rep.setText("Repetiton effectué : " + trainingOutput.getRepetitions()+"");
        tvdate.setText("Fait le  : " + trainingOutput.getTrainingDateValue()+"");
    }

}
