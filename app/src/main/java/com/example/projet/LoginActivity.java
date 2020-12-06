package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import api.ApiClient;
import model.inputDataModel.UserFitnessInputLogin;
import model.outputDataModel.UserFitnessOutputLogin;
import repository.AuthRepository;

public class LoginActivity extends AppCompatActivity {
    private UserFitnessInputLogin userFitnessInputLogin;
    private AuthRepository authRepository;
    private EditText edit_name,edit_pswd;
    private Button btn_login;
    private String name,pswd;
//ceci est un push a supp
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        init();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    name=edit_name.getText().toString();
                    pswd=edit_pswd.getText().toString();
                    userFitnessInputLogin = new UserFitnessInputLogin(name,pswd);
                    authRepository.loginUser(userFitnessInputLogin).observe(LoginActivity.this, new Observer<UserFitnessOutputLogin>() {
                    @Override
                    public void onChanged(UserFitnessOutputLogin userFitnessOutputLogin) {
                        ApiClient.setToken(userFitnessOutputLogin.getToken());
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     *
     *====================================
     *       Init the view
     *====================================
     */


    public void init(){
        edit_name = findViewById(R.id.edit_name);
        edit_pswd = findViewById(R.id.edit_pswd);
        authRepository = new AuthRepository();
        btn_login = findViewById(R.id.button);


    }

    /**
     *
     *====================================
     *       Changement de View
     *====================================
     */

    public void goToOffline(View view) {
        Intent intent=new Intent(LoginActivity.this, OfflineActivity.class);
        startActivity(intent);
    }

    public void goToRegister(View view) {
        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}