package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.supportingonline.hrapp.Adapter.ViewPagerAdapter;
import com.supportingonline.hrapp.Fragment.FirstAddFragment;
import com.supportingonline.hrapp.Fragment.SecondAddFragment;
import com.supportingonline.hrapp.Fragment.SubmitAddFragment;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ArrayList<Fragment> fragments=new ArrayList<>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        tabLayout=(TabLayout)findViewById(R.id.add_tabLayout);
        viewPager=(ViewPager)findViewById(R.id.add_viewpager);

        // pager
        adapter=new ViewPagerAdapter(this,getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initTab(){
        fragments.clear();
        fragments.add(new FirstAddFragment());
        fragments.add(new SecondAddFragment());
        fragments.add(new SubmitAddFragment());
        adapter.notifyDataSetChanged();


    }
}
