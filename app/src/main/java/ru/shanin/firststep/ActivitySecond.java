package ru.shanin.firststep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class ActivitySecond extends AppCompatActivity {
    // add some const value to set name work processes
    private static final String EXTRA_MOD;
    private static final String EXTRA_MOD_EDIT;
    private static final String EXTRA_MOD_NEW;
    private static String MOD_NAME;
    private static final String EXTRA_DATA;
    private static String INPUT_DATA;
    private static Data local_data;

    private TextView tv;

    static {
        EXTRA_MOD = "extra_mod";
        EXTRA_MOD_EDIT = "extra_mod_edit";
        EXTRA_MOD_NEW = "extra_mod_new";
        EXTRA_DATA = "extra_data";
    }

    // third step: create constructor:
    // without args. not use in 99.99%
    public static Intent launchSecondActivity(Context context) {
        return new Intent(context, ActivitySecond.class);
    }

    // with args. use in 99.99%
    public static Intent launchSecondActivityWithArgsNew(Context context) {
        Intent intent = new Intent(context, ActivitySecond.class);
        intent.putExtra(EXTRA_MOD, EXTRA_MOD_NEW);
        return intent;
    }

    // with args. use in 99.99%
    public static Intent launchSecondActivityWithArgsEdit(Context context, String args) {
        Intent intent = new Intent(context, ActivitySecond.class);
        intent.putExtra(EXTRA_MOD, EXTRA_MOD_EDIT);
        intent.putExtra(EXTRA_DATA, args);
        return intent;
    }

    private void parseIntent() {
        if (!getIntent().hasExtra(EXTRA_MOD)) throw new RuntimeException("Extra mod is absent");
        MOD_NAME = getIntent().getStringExtra(EXTRA_MOD);
        if (!MOD_NAME.equals(EXTRA_MOD_EDIT) && !MOD_NAME.equals(EXTRA_MOD_NEW))
            throw new RuntimeException("Unknown extra mod " + MOD_NAME);
        if (MOD_NAME.equals(EXTRA_MOD_NEW)) {
            local_data = new Data(
                    NewData.genFirstName(), NewData.genSecondName(), NewData.genPhoneNumber());
            Log.d("DATA", "sa_new: data = " + local_data);
        }
        if (MOD_NAME.equals(EXTRA_MOD_EDIT)) {
            if (!getIntent().hasExtra(EXTRA_DATA))
                throw new RuntimeException("Input args is absent");
            INPUT_DATA = getIntent().getStringExtra(EXTRA_DATA);
            local_data = (new Gson()).fromJson(INPUT_DATA, Data.class);
            Log.d("DATA", "sa_edit: data = " + local_data);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        parseIntent();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupView();
    }

    private void initView() {
        //TODO init Views
        tv = findViewById(R.id.tv);
    }

    private void setupView() {
        //TODO setup Views

        //TODO work with INPUT_DATA
        tv.setText(local_data.toString());
    }
}