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


public class ActivitySportAdapter extends RecyclerView.Adapter<ActivitySportAdapter.MyViewHolder>{

    private List<ActivitiesByCategorieOutput> list;

    public ActivitySportAdapter(List<ActivitiesByCategorieOutput> list){
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_activities;

        public MyViewHolder(final View view){
            super(view);
            name_activities = view.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public ActivitySportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sport_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitySportAdapter.MyViewHolder holder, int position) {
        /*String name = list.get(position).getName();
        holder.name_activities.setText(name);*/

        List<ActivitySport> activities = list.get(position).getActivities();
        for(int i=0; i<activities.size();i++){
            String activities_name = activities.get(i).getName();
            holder.name_activities.setText(activities_name);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
