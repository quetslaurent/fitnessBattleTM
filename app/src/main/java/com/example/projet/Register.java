package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.UserFitness;
import repository.UserRepository;

public class Register extends AppCompatActivity {

    private EditText txt_mail,txt_password,txt_name;
    private String mail;
    private String password;
    private String name;
    private Button btn_register;
    private UserFitness userFitness;
    private UserRepository userRepository;
    private List<UserFitness>usersFitness ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        userRepository.query().observe(this, new Observer<List<UserFitness>>() {
            @Override
            public void onChanged(List<UserFitness> users) {
                Log.i("UserSql", users.toString());
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instanciation
                mail =txt_mail.getText().toString();
                password = txt_password.getText().toString();
                name=txt_name.getText().toString();

                //verifie si les vars sont null
                if(name.isEmpty()){
                    Toast.makeText(Register.this,"Username required",Toast.LENGTH_LONG).show();
                }

                else if(mail.isEmpty()){
                    Toast.makeText(Register.this,"Mail required",Toast.LENGTH_LONG).show();
                }

                else if(password.isEmpty()){
                    Toast.makeText(Register.this,"Password required",Toast.LENGTH_LONG).show();
                }
                else{
                  userFitness = new UserFitness(0,name,password,mail,false);
                  createUser(userFitness);
                }
            }
        });

    }

    public void createUser(UserFitness userFitness){
            Toast.makeText(Register.this,"Mail already used",Toast.LENGTH_LONG).show();
            userRepository.create(userFitness).observe(Register.this, new Observer<UserFitness>() {
                @Override
                public void onChanged(UserFitness userFitness) {
                    Log.i("user", userFitness.toString());
                    Toast.makeText(Register.this,"User created",Toast.LENGTH_LONG).show();
                }
            });

    }

    private void initView() {
        userRepository = new UserRepository();
        txt_mail=(EditText) findViewById(R.id.edit_txt);
        txt_password = (EditText)findViewById(R.id.editTextTextPassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_name = (EditText)findViewById(R.id.edit_txt_name);
        usersFitness = new ArrayList<>();
    }


}
