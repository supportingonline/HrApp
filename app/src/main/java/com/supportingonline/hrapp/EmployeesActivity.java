package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.supportingonline.hrapp.Adapter.UsersAdapter;
import com.supportingonline.hrapp.Custom.MySizes;
import com.supportingonline.hrapp.Custom.SpaceRecycler_V;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.UsersModel;

import java.util.ArrayList;

public class EmployeesActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<UsersModel> arrayList=new ArrayList<>();
    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_users);

        // recycler
        arrayList.clear();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(new SpaceRecycler_V(MySizes.gethight(this)/50));
        adapter=new UsersAdapter(arrayList, this, new OnPress() {
            @Override
            public void onClick(View view, int position) {

            }
        });

        recyclerView.setAdapter(adapter);

        loadUsers();

    }

    private void loadUsers() {
        for (int i= 0;i<10;i++){
            UsersModel model=new UsersModel();
            arrayList.add(model);
        }
        adapter.notifyDataSetChanged();
    }
}
