package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class IMC extends AppCompatActivity {

    Button envoyer = null;
    Button raz = null;
    EditText poids = null;
    EditText taille = null;
    RadioGroup group = null;
    TextView result = null;
    private final String defaut = "Cliquez sur le bouton « Calculer l'IMC » pour le résultat.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);
        // On récupère toutes les vues dont on a besoin
        envoyer = (Button) findViewById(R.id.calcul);
        taille = (EditText) findViewById(R.id.taille);
        poids = (EditText) findViewById(R.id.poids);
        group = (RadioGroup) findViewById(R.id.group);
        result = (TextView) findViewById(R.id.result);
        // On attribue un listener adapté aux vues qui en ont besoin
        envoyer.setOnClickListener(envoyerListener);
        taille.addTextChangedListener(textWatcher);
        poids.addTextChangedListener(textWatcher);

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            result.setText(defaut);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
    };

    private View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                // Si la megafonction n'est pas activée
                // On récupère la taille
                String t = taille.getText().toString();
                // On récupère le poids
                String p = poids.getText().toString();
                float tValue = Float.valueOf(t);
                // Puis on vérifie que la taille est cohérente
                if(tValue == 0)
                    Toast.makeText(IMC.this, "Ta taille est incorrecte",
                            Toast.LENGTH_SHORT).show();
                else {
                    float pValue = Float.valueOf(p);
                    // Si l'utilisateur a indiqué que la taille était en centimètres
                    // On vérifie que la Checkbox sélectionnée est la deuxième à l'aide de son identifiant

                    if(group.getCheckedRadioButtonId() == R.id.radio2)
                        tValue = tValue / 100;
                    tValue = (float)Math.pow(tValue, 2);
                    float imc = pValue / tValue;

                    if(imc <16.5){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en famine.");
                    }
                    else if(imc >=16.5 && imc <18.5){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en maigreur.");
                    }
                    else if(imc >=18.5 && imc <25){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en corpulence normale.");
                    }
                    else if(imc >=25 && imc <30){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en surpoids.");
                    }
                    else if(imc >=30 && imc <35){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en obésité modérée.");
                    }
                    else if(imc >=35 && imc <40){
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en obésité sévère.");
                    }
                    else{
                        result.setText("Votre IMC est de " + String.valueOf(imc) +"\nVous êtes en obésité massive.");
                    }


                }
        }
    };





}