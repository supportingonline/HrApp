package com.supportingonline.hrapp.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.supportingonline.hrapp.Api.MyRequest;
import com.supportingonline.hrapp.Api.OnErrorRequest;
import com.supportingonline.hrapp.Api.OnSuccessRequest;
import com.supportingonline.hrapp.Custom.KeyBoardHiding;
import com.supportingonline.hrapp.Custom.MyFragmentCustom;
import com.supportingonline.hrapp.Custom.MyFragment;

import com.supportingonline.hrapp.Custom.Myvollysinglton;
import com.supportingonline.hrapp.Dialogs.MyProgressDialog;
import com.supportingonline.hrapp.HomeActivity;
import com.supportingonline.hrapp.InterFaces.ErrorCall;
import com.supportingonline.hrapp.InterFaces.SuccessCall;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.Views.MyEditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends MyFragmentCustom {


    private TextView forgetenPassword,alarmEmail,alarmPassword;
    private EditText eemail,epassword;
    private Button btn_login;


    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_login, container, false);

        eemail=(EditText)view.findViewById(R.id.login_email);
        epassword=(EditText)view.findViewById(R.id.login_password);
        btn_login=(Button)view.findViewById(R.id.login_btn);
        forgetenPassword=(TextView)view.findViewById(R.id.login_forget);
        alarmEmail=(TextView)view.findViewById(R.id.login_alarm_email);
        alarmPassword=(TextView)view.findViewById(R.id.login_alarm_password);

        // set visible of alarm
        alarmEmail.setVisibility(View.INVISIBLE);
        alarmPassword.setVisibility(View.INVISIBLE);



        // login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KeyBoardHiding.hide(v,view.getContext());

                String email=eemail.getText().toString().trim();
                String password=epassword.getText().toString().trim();

                if (email.length()==0){
                    alarmEmail.setVisibility(View.VISIBLE);
                    alarmEmail.setText(view.getContext().getResources().getString(R.string.this_field_is_required));
                }else if (!MyEditText.isEmail(email)){
                    alarmEmail.setVisibility(View.VISIBLE);
                    alarmEmail.setText(view.getContext().getResources().getString(R.string.valiedemail));
                }

                else {
                    alarmEmail.setVisibility(View.INVISIBLE);
                    if (password.length()==0){
                        alarmPassword.setVisibility(View.VISIBLE);
                        alarmPassword.setText(view.getContext().getResources().getString(R.string.this_field_is_required));
                    }
                    else if (password.length()<5){
                        alarmPassword.setVisibility(View.VISIBLE);
                        alarmPassword.setText(view.getContext().getResources().getString(R.string.valiedpassword));
                    }else {
                        alarmPassword.setVisibility(View.INVISIBLE);

                        // login
                        login(email,password);
                    }
                }




            }
        });

        // forget
        forgetenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment.changeLoginFragment(view.getContext(),new ForgetPasswordFragment(),R.id.login_container,
                        R.anim.right_in,R.anim.right_out);
            }
        });


        // edit email listener
        eemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length()>0) {

                    if (!MyEditText.isEmail(s.toString().trim())) {
                        alarmEmail.setText(view.getContext().getResources().getString(R.string.valiedemail));
                        alarmEmail.setVisibility(View.VISIBLE);
                    } else {
                        alarmEmail.setVisibility(View.INVISIBLE);
                    }
                }else {
                    alarmEmail.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        return view;
    }

    private void login(final String email, final String password) {

        String url=domain()+"api/login";
        showDialog();
        StringRequest request=new MyRequest("",1,url,new OnSuccessRequest(new SuccessCall() {
            @Override
            public void OnBack(JSONObject object) {

                // success
                Log.i("responze",object.toString());



            }
        }),new OnErrorRequest(view.getContext(), new ErrorCall() {
            @Override
            public void OnBack() {

                // error
              cancelDialog();


            }
        })){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map= new HashMap<>();
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };

        Myvollysinglton.getInstance(view.getContext()).addtorequst(request);
    }

    private void goToHomeActivity(){
        startActivity(new Intent(view.getContext(), HomeActivity.class));
        getActivity().overridePendingTransition(R.anim.slide_from_righ,R.anim.slide_to_left);
    }
}
