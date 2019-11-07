package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.supportingonline.hrapp.Adapter.ViewPagerAdapter;
import com.supportingonline.hrapp.Fragment.FirstAddFragment;
import com.supportingonline.hrapp.Fragment.SecondAddFragment;
import com.supportingonline.hrapp.Fragment.SubmitAddFragment;
import com.supportingonline.hrapp.Views.TabLayoutViews;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title;
    private View backView;

    public static TabLayout tabLayout;
    private ViewPager viewPager;

    public static ArrayList<Fragment> fragments=new ArrayList<>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        tabLayout=(TabLayout)findViewById(R.id.add_tabLayout);
        viewPager=(ViewPager)findViewById(R.id.add_viewpager);
        toolbar=(Toolbar)findViewById(R.id.add_toolbar);
        title=(TextView)toolbar.findViewById(R.id.t_normal_title);
        backView=(View) toolbar.findViewById(R.id.t_normal_back);


        //title
        title.setText(getResources().getString(R.string.createnewuser));

        // back
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // pager
        adapter=new ViewPagerAdapter(this,getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initTab();


    }

    private void initTab(){
        fragments.clear();
        fragments.add(new FirstAddFragment());
        fragments.add(new SecondAddFragment());
        fragments.add(new SubmitAddFragment());
        adapter.notifyDataSetChanged();

        tabLayout.getTabAt(0).setCustomView(TabLayoutViews.getTabView(this,false));
        tabLayout.getTabAt(1).setCustomView(TabLayoutViews.getTabView(this,false));
        tabLayout.getTabAt(2).setCustomView(TabLayoutViews.getTabView(this,false));


    }
}
