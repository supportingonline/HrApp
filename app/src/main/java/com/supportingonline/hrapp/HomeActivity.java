package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
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


    private AnyChartView piechart;
    private Pie pie ;

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
        piechart=(AnyChartView) findViewById(R.id.home_pie_chart) ;



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
        pie=AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Apples", 6371664));
        data.add(new ValueDataEntry("Pears", 789622));
        data.add(new ValueDataEntry("Bananas", 7216301));
        data.add(new ValueDataEntry("Grapes", 1486621));
        data.add(new ValueDataEntry("Oranges", 1200000));

        pie.data(data);

        pie.title("Fruits imported in 2015 (in kg)");

        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        piechart.setChart(pie);
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

    // pop up menu
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