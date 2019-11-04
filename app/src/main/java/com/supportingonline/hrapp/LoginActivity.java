package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.supportingonline.hrapp.Dialogs.MyProgressDialog;




public class LoginActivity extends AppCompatActivity {


    private MyProgressDialog progressDialog;
    private TextView forgetenPassword;
    private EditText eemail,epassword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        eemail=(EditText)findViewById(R.id.login_email);
        epassword=(EditText)findViewById(R.id.login_password);
        btn_login=(Button)findViewById(R.id.login_btn);
        forgetenPassword=(TextView)findViewById(R.id.login_forget);



        // progress dialog
        progressDialog=new MyProgressDialog(this);
        //progressDialog.show();

        // login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                overridePendingTransition(R.anim.slide_from_righ,R.anim.slide_to_left);
            }
        });

        // forget
        forgetenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Forgotten_Password_Activity.class));
                overridePendingTransition(R.anim.fadin,R.anim.fadout);
            }
        });



    }




}
