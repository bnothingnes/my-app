package com.example.my_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingDialog {
    private Activity myactivity;
    private AlertDialog alert;

    LoadingDialog(Activity myactivity) {
        this.myactivity = myactivity;
    }

    void startLoading() {
        AlertDialog.Builder builder = new AlertDialog.Builder(myactivity);
        LayoutInflater inflater = myactivity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_loading, null));
        builder.setCancelable(false);
        alert = builder.create();
        alert.show();
    }

    void closeLoading() {
        alert.dismiss();
    }
}
