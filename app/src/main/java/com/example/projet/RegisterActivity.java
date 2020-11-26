package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mail.GMailSender;
import model.UserFitness;
import viewModel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    private EditText txt_mail,txt_password,txt_name;
    private String mail;
    private String password;
    private String name;
    private Button btn_register;
    private UserFitness userFitness;
    private RegisterViewModel registerViewModel;
  // private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        //userRepository = new UserRepository();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instanciation
                mail =txt_mail.getText().toString();
                password = txt_password.getText().toString();
                name=txt_name.getText().toString();

                //verifie si les vars sont null
                if(name.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Username required",Toast.LENGTH_LONG).show();
                }

                else if(mail.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Mail required",Toast.LENGTH_LONG).show();
                }

                else if(password.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Password required",Toast.LENGTH_LONG).show();
                }
                else{
                  userFitness = new UserFitness(0,name,password,mail,false);
                  registerViewModel.createUser(userFitness);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                GMailSender sender = new GMailSender("fitnessbattle2000@gmail.com",
                                        "joeynicoguiguiquets");
                                sender.sendMail("Inscription à Fitness Battle ", " Bienvenue sur Fitness Battle. " +
                                                "\nDecouvrez notre application pour vous boostez vous et vos amis a donner le meilleur de vous même ! \n" +
                                                "\n\n L'équipe de développement" +
                                                "\n Louvieaux Nicolas" +
                                                "\n Hage Joey" +
                                                "\n Mercier Guillaume" +
                                                "\n Quets Laurent",
                                        "fitnessbattle2000@gmail.com", txt_mail.getText().toString());
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }
                        }

                    }).start();
                }
            }
        });

    }

    private void initView() {
        txt_mail=(EditText) findViewById(R.id.edit_txt);
        txt_password = (EditText)findViewById(R.id.editTextTextPassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_name = (EditText)findViewById(R.id.edit_txt_name);
        registerViewModel =  new ViewModelProvider(this).get(RegisterViewModel.class);

    }


}
