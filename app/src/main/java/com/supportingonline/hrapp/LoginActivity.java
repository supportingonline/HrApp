package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import com.supportingonline.hrapp.Custom.MyFragment;
import com.supportingonline.hrapp.Fragment.LoginFragment;

import net.skoumal.fragmentback.BackFragmentHelper;


public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        MyFragment.changeLoginFragment(this,new LoginFragment(),R.id.login_container,R.anim.fadin,R.anim.fadout);

    }


    @Override
    public void onBackPressed() {
        if(!BackFragmentHelper.fireOnBackPressedEvent(this)) {
            super.onBackPressed();
        }

    }
}
