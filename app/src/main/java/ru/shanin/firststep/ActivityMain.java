package ru.shanin.firststep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// first step - refactor->rename class: MainActivity->ActivityMain
//second step - add second activity: ActivitySecond:file->new->Activity->Empty Activity
public class ActivityMain extends AppCompatActivity {
    private Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupView();
    }


    private void initView() {
        bt = findViewById(R.id.bt);
    }

    private void setupView() {
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(
                                ActivityMain.this,
                                ActivitySecond.class);
                        startActivity(intent);
                    }
                }
        );
    }
}