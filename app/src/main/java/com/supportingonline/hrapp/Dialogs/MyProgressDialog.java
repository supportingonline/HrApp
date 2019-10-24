package com.supportingonline.hrapp.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.supportingonline.hrapp.R;

public class MyProgressDialog extends Dialog {

    public MyProgressDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        getWindow().setLayout(-1,-2);
    }
}
