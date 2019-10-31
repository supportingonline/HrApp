package com.supportingonline.hrapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.Holder.UsersHolder;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.UsersModel;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.Views.MyViewHolder;

import java.util.ArrayList;

public class UsersAdapter  extends RecyclerView.Adapter<UsersHolder>{

    private ArrayList<UsersModel> arrayList;
    private Context context;
    private OnPress onPress;

    public UsersAdapter(ArrayList<UsersModel> arrayList, Context context,OnPress onPress) {
        this.arrayList = arrayList;
        this.context = context;
        this.onPress = onPress;
    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return (UsersHolder) MyViewHolder.myuserholder(context, R.layout.recycler_users,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, final int position) {



        // click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPress.onClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
