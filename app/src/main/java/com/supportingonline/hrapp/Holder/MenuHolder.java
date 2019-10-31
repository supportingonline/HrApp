package com.supportingonline.hrapp.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.R;

public class MenuHolder extends RecyclerView.ViewHolder{

    public TextView textView;
    public ImageView imageView;

    public MenuHolder(@NonNull View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.r_menu_title);
        imageView=(ImageView)itemView.findViewById(R.id.r_menu_icon);
    }
}
