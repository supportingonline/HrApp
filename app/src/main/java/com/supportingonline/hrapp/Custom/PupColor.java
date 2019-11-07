package com.supportingonline.hrapp.Custom;

import com.supportingonline.hrapp.Model.ColorPupModel;
import com.supportingonline.hrapp.R;

import java.util.ArrayList;
import java.util.Random;

public class PupColor {


    public static ColorPupModel PupColor(){
        ArrayList<ColorPupModel> colorPupModels=new ArrayList<>();
        int[] heads={R.color.custom1,R.color.custom2,R.color.custom3,
                R.color.custom5,R.color.colorAccent};
         int[] seconds={R.color.hollowcustom3,R.color.hollowcustom2,R.color.hollowcustom6,
                 R.color.hollowcustom4,R.color.hollowcustom5};
        for (int i=0;i<heads.length;i++){
            ColorPupModel model=new ColorPupModel();
            model.setHeadColor(heads[i]);
            model.setSecondColor(seconds[i]);
            colorPupModels.add(model);
        }
        Random rand = new Random();
        int randomNumber=rand.nextInt(5);

        return colorPupModels.get(randomNumber);
    }
}
