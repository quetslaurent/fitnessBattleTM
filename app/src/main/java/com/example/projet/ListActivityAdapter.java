package com.example.projet;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

import model.ActivitySport;

public class ListActivityAdapter extends ArrayAdapter<ActivitySport> {
    private Context context;
    private int resource;

    public ListActivityAdapter(Context context, int textViewResourceId, List<ActivitySport> activities) {
        super(context,textViewResourceId,activities);
        resource = textViewResourceId;
        this.context = context;
    }

    /**
     * Si la convertview est null , on va la creer en chargeant les composants (checkbox,texte)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ActivtyViewHolder activtyViewHolder;
        // Gestion des performances : on "inflate" et on recherche les composants si nécessaire
        if (convertView == null) {
            convertView = View.inflate(context, resource, null);

            activtyViewHolder = new ActivtyViewHolder();
            activtyViewHolder.text = (TextView)convertView.findViewById(R.id.TextActi);
            activtyViewHolder.check = (CheckBox)convertView.findViewById(R.id.checkActivity);

            convertView.setTag(activtyViewHolder);
        } else {
            /**
             * si elle existe deja , il a juste a la recuperer
             */
            activtyViewHolder = (ActivtyViewHolder) convertView.getTag();
        }

        /**
         * permet d'initialiser les var , text et check , en recuperant l'objet ActivitySport
         */
        ActivitySport activitySport = getItem(position);
        if (activitySport != null) {
            activtyViewHolder.text.setText(activitySport.getName());
            activtyViewHolder.check.setChecked(activitySport.isChecked());
            activtyViewHolder.check.setTag(position); //permet de recuperer sa position dans la liste
        }
        return convertView;
    }

    /**
     *  Classe statique , qui permet de parcourir la liste plus facilement
     */
    static class ActivtyViewHolder {
        TextView text;
        CheckBox check;
    }
}
