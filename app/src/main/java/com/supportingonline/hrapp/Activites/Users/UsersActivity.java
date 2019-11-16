package com.supportingonline.hrapp.Activites.Users;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.supportingonline.hrapp.Adapter.UsersAdapter;
import com.supportingonline.hrapp.AddUserActivity;
import com.supportingonline.hrapp.Custom.MySizes;
import com.supportingonline.hrapp.Custom.SpaceRecycler_V;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.UsersModel;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.UserActivity;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView title;
    private View backView;

    private RelativeLayout addLayout;
    private EditText search;
    private RecyclerView recyclerView;
    private ArrayList<UsersModel> arrayList=new ArrayList<>();
    private UsersAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_employees);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_users);
        addLayout=(RelativeLayout)findViewById(R.id.users_add);
        toolbar=(Toolbar)findViewById(R.id.users_toolbar);
        title=(TextView)toolbar.findViewById(R.id.t_normal_title);
        backView=(View) toolbar.findViewById(R.id.t_normal_back);
        search= (EditText) findViewById(R.id.users_search);


        //title
        title.setText(getResources().getString(R.string.users));

        // back
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // add users
        addLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsersActivity.this, AddUserActivity.class));
            }
        });

        // recycler
        arrayList.clear();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.addItemDecoration(new SpaceRecycler_V(MySizes.gethight(this)/50));
        adapter=new UsersAdapter(arrayList, this, new OnPress() {
            @Override
            public void onClick(View view, int position) {

                // click card
                startActivity(new Intent(UsersActivity.this, UserActivity.class));
            }
        }, new OnPress() {
            @Override
            public void onClick(View view, int position) {
                // click more
                popUp(view);


            }
        });

        recyclerView.setAdapter(adapter);



        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loadUsers();




    }

    private void loadUsers() {
        String[] names={"ahmed","nagy","mohamed","karim","mahmoud","hossam","abd elghany","refaat","makrmalla","yosuef"};
        for (int i= 0;i<10;i++){
            UsersModel model=new UsersModel();
            model.setName(names[i]);
            arrayList.add(model);
        }
        adapter.notifyDataSetChanged();
    }

    // actions

    // pop up menu
    private void popUp(View view){
        PopupMenu popupMenu=new PopupMenu(UsersActivity.this,view);
        popupMenu.getMenuInflater().inflate(R.menu.user_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();

                switch (id){


                }
                return true;
            }
        });
        popupMenu.show();
    }
}
