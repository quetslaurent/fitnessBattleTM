package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText txt_mail,txt_password;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_mail.getText().toString().isEmpty()|| txt_password.getText().toString().isEmpty()){
                    Toast.makeText(Register.this,"Mail / password required",Toast.LENGTH_LONG).show();
                }else{
                    //preceed to register
                }
            }
        });

    }

    private void initView() {
        txt_mail=(EditText) findViewById(R.id.edit_txt);
        txt_password = (EditText)findViewById(R.id.editTextTextPassword);
        btn_register = (Button) findViewById(R.id.btn_register);
    }

}
