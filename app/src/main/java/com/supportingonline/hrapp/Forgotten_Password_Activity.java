package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Forgotten_Password_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten__password);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadin,R.anim.fadout);
    }
}
