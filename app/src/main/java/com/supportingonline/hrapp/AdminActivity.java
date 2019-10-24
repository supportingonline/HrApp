package com.supportingonline.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.supportingonline.hrapp.Adapter.HeadCardAdapter;
import com.supportingonline.hrapp.Adapter.MenuAdapter;
import com.supportingonline.hrapp.Custom.MySizes;
import com.supportingonline.hrapp.Custom.SpaceRecycler_H;
import com.supportingonline.hrapp.Custom.SpaceRecycler_V;
import com.supportingonline.hrapp.Dialogs.MyProgressDialog;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.HeadCardModel;
import com.supportingonline.hrapp.Model.MenuModel;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    private Toolbar toolbar;
    private ImageView menu_icon;

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private ArrayList<MenuModel> menuModels=new ArrayList<>();


    private HeadCardAdapter headCardAdapter;
    private RecyclerView recyclerHeadCard;
    private ArrayList<HeadCardModel> headCardList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // init
        toolbar=(Toolbar)findViewById(R.id.admin_toolbar);
        menu_icon=(ImageView)toolbar.findViewById(R.id.tb_admin_image);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_menu_admin);
        drawer=(DrawerLayout)findViewById(R.id.admin_drawer);




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

            }
        });
        recyclerHeadCard.setAdapter(headCardAdapter);
        // init head
        initHead();



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
            menuModels.add(model);
        }

        menuAdapter=new MenuAdapter(menuModels, new OnPress() {
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
