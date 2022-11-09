package ru.shanin.firststep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {
    // third step: create constructor:

    // without args. not use in 99.99%
    public static Intent launchSecondActivity(Context context) {
        return new Intent(context, ActivitySecond.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        setupView();
    }

    private void initView() {
        //TODO init Views
    }

    private void setupView() {
        //TODO setup Views
    }
}