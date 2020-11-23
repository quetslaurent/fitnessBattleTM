package com.example.projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import model.UserFitness;

public class UserFitnessArrayAdapter extends ArrayAdapter<UserFitness> {

    public UserFitnessArrayAdapter(@NonNull Context context, int ressource, @NonNull List<UserFitness> objects)
    {
        super(context,ressource,objects);
    }




}
