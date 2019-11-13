package com.supportingonline.hrapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supportingonline.hrapp.Custom.PupColor;
import com.supportingonline.hrapp.Holder.UsersHolder;
import com.supportingonline.hrapp.InterFaces.OnPress;
import com.supportingonline.hrapp.Model.ColorPupModel;
import com.supportingonline.hrapp.Model.UsersModel;
import com.supportingonline.hrapp.R;
import com.supportingonline.hrapp.Views.MyViewHolder;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter  extends RecyclerView.Adapter<UsersHolder> implements Filterable {

    private ArrayList<UsersModel> arrayList;
    private ArrayList<UsersModel> arrayListFiltered;
    private Context context;
    private OnPress onPress;
    private OnPress onPressMore;


    public UsersAdapter(ArrayList<UsersModel> arrayList, Context context,OnPress onPress,OnPress onPressMore) {
        this.arrayList = arrayList;
        this.arrayListFiltered = arrayList;
        this.context = context;
        this.onPress = onPress;
        this.onPressMore = onPressMore;

    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return (UsersHolder) MyViewHolder.myuserholder(context, R.layout.recycler_users,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, final int position) {


        // get model
        UsersModel user=arrayListFiltered.get(position);


        // name
        holder.name.setText(user.getName());


        // click more

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onPressMore.onClick(v,position);
            }
        });

        // click view profile
        holder.layoutContanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPress.onClick(v,position);
            }
        });


        // colors
        ColorPupModel model= PupColor.PupColor();
        holder.layoutContanier.setBackgroundTintList(context.getResources().getColorStateList(model.getSecondColor()));
        holder.textClick.setTextColor(context.getResources().getColor(model.getHeadColor()));
        holder.more.setImageTintList(context.getResources().getColorStateList(model.getHeadColor()));



    }



    @Override
    public int getItemCount() {
        return arrayListFiltered.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                arrayListFiltered = new ArrayList<>();
                if (charString.isEmpty()) {
                    arrayListFiltered = arrayList;
                } else {
                    ArrayList<UsersModel> filteredList = new ArrayList<>();
                    for (UsersModel row : arrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match

                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getName().contains(charSequence)) {
                            Log.d("name",row.getName());
                            filteredList.add(row);
                        }
                    }

                    arrayListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayListFiltered;
                Log.d("count", String.valueOf(arrayListFiltered.size()));
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrayListFiltered = (ArrayList<UsersModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


}
