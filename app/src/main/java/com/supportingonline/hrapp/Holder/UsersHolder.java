package com.supportingonline.hrapp.Holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.R;

public class UsersHolder  extends RecyclerView.ViewHolder {

    public ImageView more,imageView;

    public UsersHolder(@NonNull View itemView) {
        super(itemView);

        more=(ImageView)itemView.findViewById(R.id.r_users_more);
        imageView=(ImageView)itemView.findViewById(R.id.r_users_image);
    }

}