package com.supportingonline.hrapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.HeadCardModel;
import com.supportingonline.hrapp.R;

import java.util.ArrayList;

public class HeadCardAdapter extends RecyclerView.Adapter<HeadCardAdapter.HeadCardHolder>{
    private ArrayList<HeadCardModel> arrayList;
    private Context context;
    private OnPress onPress;

    public HeadCardAdapter(ArrayList<HeadCardModel> arrayList, Context context, OnPress onPress) {
        this.arrayList = arrayList;
        this.context = context;
        this.onPress = onPress;
    }

    @NonNull
    @Override
    public HeadCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_head_card,parent,false);
        HeadCardHolder vh=new HeadCardHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HeadCardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    protected class HeadCardHolder extends RecyclerView.ViewHolder{

        public HeadCardHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
