package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import model.UserFitness;
import repository.UserRepository;
import viewModel.RegisterModel;

public class Register extends AppCompatActivity {

    private EditText txt_mail,txt_password,txt_name;
    private String mail;
    private String password;
    private String name;
    private Button btn_register;
    private UserFitness userFitness;
    private RegisterModel registerModel;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        //registerModel = new ViewModelProvider(this).get(RegisterModel.class);
        userRepository = new UserRepository();
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
                  //registerModel.createUser(userFitness);
                    createUser(userFitness);
                }
            }
        });

    }

    public void createUser(UserFitness userFitness){
        userRepository.create(userFitness).observe(this, new Observer<UserFitness>() {
            @Override
            public void onChanged(UserFitness userFitness) {

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
