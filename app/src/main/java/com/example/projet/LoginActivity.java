package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.ApiClient;
import model.inputDataModel.UserFitnessInputLogin;
import model.outputDataModel.UserFitnessOutputLogin;
import repository.AuthRepository;
import viewModel.LoginViewModel;
import viewModel.RegisterViewModel;

public class LoginActivity extends AppCompatActivity {

    private UserFitnessInputLogin userFitnessInputLogin;
    private AuthRepository authRepository;
    private EditText edit_name,edit_pswd;
    private Button btn_login;
    private String name,pswd;
    private LoginViewModel loginViewModel;
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
                    loginViewModel.login(userFitnessInputLogin).observe(LoginActivity.this, new Observer<UserFitnessOutputLogin>() {
                        @Override
                        public void onChanged(UserFitnessOutputLogin userFitnessOutputLogin) {
                            if(userFitnessOutputLogin != null ) {
                                ApiClient.setToken(userFitnessOutputLogin.getToken());
                                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                startActivity(intent);
                            }
                            else if (userFitnessOutputLogin==null) {
                                Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                            }
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
        loginViewModel =  new ViewModelProvider(this).get(LoginViewModel.class);


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

    public  Context getContext(){
        Context context = LoginActivity.this;
        return context;
    }

}