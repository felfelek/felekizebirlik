package com.lecboxyazilim.lecbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent toTeacherFinder = new Intent(Main2Activity.this,FenEdebiyatActivity.class);
        startActivity(toTeacherFinder);
    }
}
