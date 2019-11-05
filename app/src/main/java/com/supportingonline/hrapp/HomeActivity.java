package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.supportingonline.hrapp.Adapter.HeadCardAdapter;
import com.supportingonline.hrapp.Adapter.MenuAdapter;
import com.supportingonline.hrapp.Custom.MySizes;
import com.supportingonline.hrapp.Custom.SpaceRecycler_H;
import com.supportingonline.hrapp.Custom.SpaceRecycler_V;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.HeadCardModel;
import com.supportingonline.hrapp.Model.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    private Toolbar toolbar;
    private ImageView menu_icon,noti_icon,more_icon;

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private ArrayList<MenuModel> menuModels=new ArrayList<>();


    private HeadCardAdapter headCardAdapter;
    private RecyclerView recyclerHeadCard;
    private ArrayList<HeadCardModel> headCardList=new ArrayList<>();


    private PieChart piechart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // init
        toolbar=(Toolbar)findViewById(R.id.admin_toolbar);
        menu_icon=(ImageView)toolbar.findViewById(R.id.tb_admin_image);
        noti_icon=(ImageView)toolbar.findViewById(R.id.tb_admin_noti);
        more_icon=(ImageView)toolbar.findViewById(R.id.tb_admin_more);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_menu_admin);
        drawer=(DrawerLayout)findViewById(R.id.admin_drawer);
        piechart=(PieChart) findViewById(R.id.home_pie_chart) ;



        // drawer
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        // menu
        initMenu();


        // recycler head
        headCardList.clear();
        recyclerHeadCard=(RecyclerView)findViewById(R.id.recycler_admin_head);
        recyclerHeadCard.setLayoutManager(new GridLayoutManager(this,2));
        recyclerHeadCard.addItemDecoration(new SpaceRecycler_H(MySizes.getwedith(this)/60));
        recyclerHeadCard.addItemDecoration(new SpaceRecycler_V(MySizes.gethight(this)/40));
        headCardAdapter=new HeadCardAdapter(headCardList, this, new OnPress() {
            @Override
            public void onClick(View view, int position) {

                startActivity(new Intent(HomeActivity.this, EmployeesActivity.class));
            }
        });
        recyclerHeadCard.setAdapter(headCardAdapter);


        // notification
        noti_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NotificationsActivity.class));
            }
        });


        // more
        more_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            popUp(v);
            }
        });



        // pie chart
        loadPieChart();



        // init head
        initHead();



    }

    private void loadPieChart() {
        piechart.setUsePercentValues(true);
        piechart.getDescription().setEnabled(false);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);

        piechart.setTransparentCircleColor(Color.WHITE);
        piechart.setTransparentCircleAlpha(110);

        piechart.setHoleRadius(58f);
        piechart.setTransparentCircleRadius(61f);

        piechart.setDrawCenterText(true);

        piechart.setRotationAngle(0);
        // enable rotation of the chart by touch
        piechart.setRotationEnabled(true);
        piechart.setHighlightPerTapEnabled(true);

        List<String> labes=new ArrayList<>() ;
        labes.add("January");
        labes.add("February");
        labes.add("March");
        labes.add("April");
        labes.add("May");
        labes.add("June");


        List<PieEntry> entries=new ArrayList<>() ;
        entries.add(new PieEntry(50, labes.get(0)));
        entries.add(new PieEntry(10, labes.get(1)));
        entries.add(new PieEntry(20, labes.get(2)));
        entries.add(new PieEntry(20, labes.get(3)));




        PieDataSet pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setColor(R.color.custom1);

        PieData pieData = new PieData(pieDataSet);


        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        piechart.setData(pieData);
        piechart.setEntryLabelColor(R.color.custom1);

        piechart.animateY(1400, Easing.EaseInOutQuad);

    }


    private void initHead() {
        String[] titles={"ahmed","nagy","mohamed"};
        int icons[]={R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user};
        for (int i= 0;i<titles.length;i++){
            HeadCardModel model=new HeadCardModel();

            headCardList.add(model);
        }
        headCardAdapter.notifyDataSetChanged();
    }

    private void initMenu() {
        menuModels.clear();
        String[] menuTtiles=getResources().getStringArray(R.array.menu_titles);
        int[] menuIcons={R.drawable.ic_email,R.drawable.ic_email};
        for (int i=0;i<menuTtiles.length;i++){
            MenuModel model=new MenuModel();
            model.setTitle(menuTtiles[i]);
            model.setIcon(menuIcons[i]);
            if (i==1){
                ArrayList<MenuModel> m=new ArrayList<>();
                MenuModel themodel=new MenuModel();
                m.add(themodel);
                model.setListInside(m);
            }
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



    // actions

    // pop up menu for admin
    private void popUp(View view){
        PopupMenu popupMenu=new PopupMenu(HomeActivity.this,view);
        popupMenu.getMenuInflater().inflate(R.menu.admin_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();

                switch (id){
                    case R.id.m_a_myprofile:

                        break;
                    case R.id.m_a_setting:
                        startActivity(new Intent(HomeActivity.this,SettingActivity.class));
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
