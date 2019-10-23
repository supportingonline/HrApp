package com.supportingonline.hrapp.Views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.supportingonline.hrapp.R;


public class TabLayoutViews {

    public static View getTabView(Context context ,int icon,int tabCountNotification){
     View v = LayoutInflater.from(context).inflate(0, null);
       // TextView tv = (TextView) v.findViewById(0);


        RelativeLayout layout=(RelativeLayout)v.findViewById(0);

       // tv.setText(String.valueOf(tabCountNotification));
        if (tabCountNotification==0){
            layout.setVisibility(View.INVISIBLE);
        }
        ImageView img = (ImageView) v.findViewById(0);
        img.setImageResource(icon);
       // img.setColorFilter(context.getResources().getColor(0, PorterDuff.Mode.SRC_IN);


        return v;
    }

    public static void selectTab(Context context,View view){
        TextView t=view.findViewById(0);
        t.setText("0");

        ImageView im=view.findViewById(0);
        im.setColorFilter(context.getResources().getColor(0), PorterDuff.Mode.SRC_IN);

        RelativeLayout layout=(RelativeLayout)view.findViewById(0);
        layout.setVisibility(View.INVISIBLE);
    }


    public static void unselectedTab(Context context,View view){

        ImageView im=view.findViewById(0);
        im.setColorFilter(context.getResources().getColor(0), PorterDuff.Mode.SRC_IN);
    }

    public static void addToCountNotification(Context context,View view){
        TextView t=view.findViewById(0);
        int s= Integer.parseInt(t.getText().toString());
        int newValue=s+1;
        t.setText(String.valueOf(newValue));

        RelativeLayout layout=(RelativeLayout)view.findViewById(0);
        layout.setVisibility(View.VISIBLE);
        MyAnimation.setAnimation(context,layout,R.anim.zominzomout);
        MyAnimation.setAnimation(context,t,R.anim.zominzomout);

    }

    public static void removeCount(Context context,View view){
        TextView t=view.findViewById(0);
        t.setText("0");
        RelativeLayout layout=(RelativeLayout)view.findViewById(0);
        layout.setVisibility(View.INVISIBLE);

    }
}
