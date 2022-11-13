package ru.shanin.firststep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// first step - refactor->rename class: MainActivity->ActivityMain
// second step - add second activity: ActivitySecond:file->new->Activity->Empty Activity
public class ActivityMain extends AppCompatActivity {
    private Button bt_new;
    private Button bt_edit;
    private Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupView();
    }


    private void initView() {
        bt_new = findViewById(R.id.bt_new);
        bt_edit = findViewById(R.id.bt_edit);
    }

    private void setupView() {
        data = new Data(
                NewData.genFirstName(), NewData.genSecondName(), NewData.genPhoneNumber());
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitySecond.
                        launchSecondActivityWithArgsNew(ActivityMain.this);
                Log.d("DATA", "bt_new: data = null");
                startActivity(intent);
            }
        });
        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitySecond.
                        launchSecondActivityWithArgsEdit(ActivityMain.this, data.toString());
                Log.d("DATA", "bt_edit: data = " + data);
                startActivity(intent);
            }
        });
    }
}