package model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.R;

import java.util.List;

import model.outputDataModel.ActivitiesByCategorieOutput;
import model.outputDataModel.ActivitySport;

public class ActivitySportAdapter extends RecyclerView.Adapter<ActivitySportAdapter.MyViewHolder> {


    private List<ActivitySport> list_activities;

    public ActivitySportAdapter(List<ActivitySport> list_activities){
        this.list_activities = list_activities;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_activities;

        public MyViewHolder(final View view){
            super(view);
            name_activities = view.findViewById(R.id.name_activities);
        }
    }



    @NonNull
    @Override
    public ActivitySportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sport_activities_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitySportAdapter.MyViewHolder holder, int position) {
        String name = list_activities.get(position).getName();
        holder.name_activities.setText(name);

    }

    @Override
    public int getItemCount() {
        return list_activities.size();
    }
}
