package com.supportingonline.hrapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.Holder.MenuHolder;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.MenuModel;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.Views.MyViewHolder;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuHolder> {

    private ArrayList<MenuModel> arrayList;
    private OnPress onPress;
    private Context context;

    public MenuAdapter(ArrayList<MenuModel> arrayList,Context context, OnPress onPress) {
        this.arrayList = arrayList;
        this.context = context;
        this.onPress = onPress;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return MyViewHolder.menuHolder(context,R.layout.recycler_menu,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, final int position) {

        // title
        holder.textView.setText(arrayList.get(position).getTitle());

        // icon
        holder.imageView.setBackgroundResource(arrayList.get(position).getIcon());

        // click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPress.onClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
