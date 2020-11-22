package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import model.UserFitness;
import repository.UserRepository;

public class Register extends AppCompatActivity {

    private EditText txt_mail,txt_password,txt_name;
    private String mail;
    private String password;
    private String name;
    private Button btn_register;
    private UserFitness userFitness;
    private int id=0;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instanciation
                mail =txt_mail.getText().toString();
                password = txt_password.getText().toString();
                name=txt_name.getText().toString();


                //verifi si les var sont null
                if(mail.isEmpty()|| password.isEmpty()){
                    Toast.makeText(Register.this,"Mail / password required",Toast.LENGTH_LONG).show();
                }else{
                    id++;
                    userFitness = new UserFitness(id,name,password,mail,false);
                    userRepository.create(userFitness).observe(Register.this, new Observer<UserFitness>() {
                        @Override
                        public void onChanged(UserFitness userFitness) {
                            Log.i("user", userFitness.toString());
                        }
                    });

                }
            }
        });

    }

    private void initView() {
        txt_mail=(EditText) findViewById(R.id.edit_txt);
        txt_password = (EditText)findViewById(R.id.editTextTextPassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_name = (EditText)findViewById(R.id.edit_txt_name);
    }

}
