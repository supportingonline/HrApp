package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.supportingonline.hrapp.Adapter.MenuAdapter;
import com.supportingonline.hrapp.Dialogs.MyProgressDialog;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.MenuModel;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private DrawerLayout drawer;


    private Toolbar toolbar;
    private ImageView menu_icon;
    private TextView tollbar_title;

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private ArrayList<MenuModel> menuModels=new ArrayList<>();

    private MyProgressDialog progressDialog;

    private EditText eemail,epassword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // init
        toolbar=(Toolbar)findViewById(R.id.login_toolbar);
        menu_icon=(ImageView)toolbar.findViewById(R.id.tb_login_image);
        tollbar_title=(TextView)toolbar.findViewById(R.id.tb_login_title);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_menu);
        drawer=(DrawerLayout)findViewById(R.id.login_drawer);
        eemail=(EditText)findViewById(R.id.login_email);
        epassword=(EditText)findViewById(R.id.login_password);
        btn_login=(Button)findViewById(R.id.login_btn);




        // drawer
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        // progress dialog
        progressDialog=new MyProgressDialog(this);
        //progressDialog.show();

        // login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,AdminActivity.class));
                overridePendingTransition(R.anim.slide_from_righ,R.anim.slide_to_left);
            }
        });

        // menu
        initMenu();

    }

    private void initMenu() {
        menuModels.clear();
        String[] menuTtiles=getResources().getStringArray(R.array.menu_titles);
        int[] menuIcons={R.drawable.ic_email,R.drawable.ic_email};
        for (int i=0;i<menuTtiles.length;i++){
            MenuModel model=new MenuModel();
            model.setTitle(menuTtiles[i]);
            model.setIcon(menuIcons[i]);
            menuModels.add(model);
        }

        menuAdapter=new MenuAdapter(menuModels, this,new OnPress() {
            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:

                        break;
                    case 1:

                        break;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(menuAdapter);
    }



}
