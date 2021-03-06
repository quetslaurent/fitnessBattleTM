package com.example.projet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import model.inputDataModel.UserFitnessInput;
import viewModel.RegisterViewModel;



public class RegisterActivity extends AppCompatActivity {

    //declaration
    private EditText txt_mail,txt_password,txt_name;
    private String mail;
    private String password;
    private String name;
    private Button btn_register;
    private UserFitnessInput userFitness;
    private RegisterViewModel registerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //init view
        initView();

        //quand on appuie pour s'enregistrer on verifie que tout les champs sont remplis si c'est le cas alors on creer le user
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
                  userFitness = new UserFitnessInput(name,password,mail,"Admin");
                  registerViewModel.createUser(userFitness);
                  btn_register.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          goToLogin(v);
                      }
                  });
                }
            }
        });

    }


    /**
     *
     *====================================
     *       Init the view
     *====================================
     */


    private void initView() {
        txt_mail=(EditText) findViewById(R.id.edit_txt);
        txt_password = (EditText)findViewById(R.id.editTextTextPassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_name = (EditText)findViewById(R.id.edit_txt_name);
        registerViewModel =  new ViewModelProvider(this).get(RegisterViewModel.class);

    }


    /**
     *
     *====================================
     *       Changement de View
     *====================================
     */

    public void goToLogin(View view) {
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}
