package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import util.SlideR;
import viewModel.ImcViewModel;
import viewModel.ProfileViewModel;

public class IMCActivity extends AppCompatActivity {

    //declaration
    Button envoyer = null;
    EditText weight,height = null;
    RadioGroup group = null;
    TextView result = null;
    private String heightReceive,weightReceive  = null;
    private final String defaut = "Cliquez sur le bouton « Calculer l'IMC » pour le résultat.";
    private ImcViewModel imcViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);
        //utilisation du slide
        SlideR.swapBack(this);
        //init view
        initView();
        // On attribue un listener adapté aux vues qui en ont besoin
        envoyer.setOnClickListener(envoyerListener);
        height.addTextChangedListener(textWatcher);
        weight.addTextChangedListener(textWatcher);
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
                heightReceive = height.getText().toString();
                // On récupère le poids
                weightReceive = weight.getText().toString();
                float tValue = Float.valueOf(heightReceive);
                float pValue = Float.valueOf(weightReceive);
                // Puis on vérifie que la taille est cohérente
                if(heightReceive == null && weightReceive==null)
                    Toast.makeText(IMCActivity.this, "Enter information",
                            Toast.LENGTH_SHORT).show();
                else {

                    // Si l'utilisateur a indiqué que la taille était en centimètres
                    // On vérifie que la Checkbox sélectionnée est la deuxième à l'aide de son identifiant

                    if(group.getCheckedRadioButtonId() == R.id.radioCentimetre)
                        tValue = tValue / 100;
                    tValue = (float)Math.pow(tValue, 2);

                    String text = imcViewModel.calculerImc(pValue,tValue);
                    result.setText(text);
                }
        }
    };


    public void initView(){
        // On récupère toutes les vues dont on a besoin
        envoyer = (Button) findViewById(R.id.calcul);
        height = (EditText) findViewById(R.id.taille);
        weight = (EditText) findViewById(R.id.poids);
        group = (RadioGroup) findViewById(R.id.groupRadio);
        result = (TextView) findViewById(R.id.result);
        imcViewModel =  new ViewModelProvider(this).get(ImcViewModel.class);
    }
}