package com.supportingonline.hrapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.Holder.MenuHolder;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.MenuModel;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.Views.MyViewHolder;

import java.util.ArrayList;

public class InsideMenuAdapter extends RecyclerView.Adapter<MenuHolder>  {

    private ArrayList<MenuModel> arrayList;
    private OnPress onPress;
    private Context context;

    public InsideMenuAdapter(ArrayList<MenuModel> arrayList, OnPress onPress, Context context) {
        this.arrayList = arrayList;
        this.onPress = onPress;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.menuHolder(context, R.layout.recycler_menu,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {

        // has child
        boolean hasChild=false;
        if (arrayList.get(position).getListInside().size()>0){
            hasChild=true;
        }


        // arrow
        if (hasChild){
            holder.arrow.setVisibility(View.VISIBLE);
        }else {
            holder.arrow.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
