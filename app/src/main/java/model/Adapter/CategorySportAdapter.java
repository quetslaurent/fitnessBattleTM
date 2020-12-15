package model.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.R;

import java.util.List;

import model.outputDataModel.ActivitiesByCategorieOutput;
import model.outputDataModel.ActivitySport;
import util.ActivitiesItemClickListener;


public class CategorySportAdapter extends RecyclerView.Adapter<CategorySportAdapter.MyViewHolder>{

    //declaration
    private List<ActivitiesByCategorieOutput> list;
    private Context context;
    private ActivitySportAdapter activitySportAdapter;
    private List<ActivitySport> list_activities;

    //constructeur
    public CategorySportAdapter(List<ActivitiesByCategorieOutput> list,Context context){
       this.context = context;
        this.list = list;
    }

    //ViewHolder du recyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_categories;
        private RecyclerView recyclerView_activities;


        public MyViewHolder(final View view){
            super(view);
            //init view
            name_categories = view.findViewById(R.id.name);
            recyclerView_activities = view.findViewById(R.id.recyclerView_activities);

        }
    }

    @NonNull
    @Override
    public CategorySportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sport_categories_item,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);

        return myViewHolder;
    }

    //mettre les données dans le reyclerview
    @Override
    public void onBindViewHolder(@NonNull CategorySportAdapter.MyViewHolder holder, int position) {
        //Afficher les categories
        String name = list.get(position).getName();
        holder.name_categories.setText(name);
        //recuperer la liste d'activités
        list_activities = list.get(position).getActivities();
        //faire un recyclerview


        activitySportAdapter = new ActivitySportAdapter(list_activities);
        RecyclerView.LayoutManager lln = new LinearLayoutManager(context);
        holder.recyclerView_activities.setLayoutManager(lln);
        holder.recyclerView_activities.setItemAnimator(new DefaultItemAnimator());
        holder.recyclerView_activities.setAdapter(activitySportAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
