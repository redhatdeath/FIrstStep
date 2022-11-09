package ru.shanin.firststep;

import android.content.Intent;
import android.os.Bundle;
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
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = new Data(
                        NewData.genFirstName(),
                        NewData.genSecondName(),
                        NewData.genPhoneNumber());
                Intent intent = ActivitySecond.launchSecondActivityWithArgsNew(
                        ActivityMain.this,
                        data.toString());
                startActivity(intent);
                bt_edit.setVisibility(View.VISIBLE);
            }
        });
        bt_edit.setVisibility(View.INVISIBLE);
        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitySecond.launchSecondActivityWithArgsNew(
                        ActivityMain.this,
                        data.toString());
                startActivity(intent);
            }
        });
    }
}