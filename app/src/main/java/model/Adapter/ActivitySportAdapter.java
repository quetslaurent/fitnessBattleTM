package model.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.R;

import org.w3c.dom.Text;

import java.util.List;

import model.outputDataModel.ActivitySport;
import util.ActivitiesItemClickListener;

public class ActivitySportAdapter extends RecyclerView.Adapter<ActivitySportAdapter.MyViewHolder> {

    //declaration
    private List<ActivitySport> list_activities;

    //constructeur
    public ActivitySportAdapter(List<ActivitySport> list_activities){
        this.list_activities = list_activities;
    }


    //ViewHolder du recyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_activities;
        private TextView activities_rep;
        private TextView activities_unit;

        public MyViewHolder(final View view){
            super(view);
            //init view
            name_activities = view.findViewById(R.id.name_activities);
            activities_rep = view.findViewById(R.id.activities_rep);
            activities_unit = view.findViewById(R.id.activities_unit);
        }
    }



    @NonNull
    @Override
    public ActivitySportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sport_activities_item,parent,false);
        return new MyViewHolder(itemView);
    }

    //mettre les données dans le reyclerview
    @Override
    public void onBindViewHolder(@NonNull ActivitySportAdapter.MyViewHolder holder, int position) {
        String name = list_activities.get(position).getName();
        double repetitions = list_activities.get(position).getRepetitions();
        String rep = ""+repetitions;
        holder.name_activities.setText(name);
        holder.activities_rep.setText(rep);
        String unit = list_activities.get(position).getUnitType();
        holder.activities_unit.setText(unit);

    }

    @Override
    public int getItemCount() {
        return list_activities.size();
    }
}
