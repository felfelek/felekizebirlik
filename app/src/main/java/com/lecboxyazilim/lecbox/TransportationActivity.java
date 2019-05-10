package com.lecboxyazilim.lecbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransportationActivity extends AppCompatActivity {
    Button manisaButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        manisaButton = findViewById(R.id.manisaSeyahatButton);
        manisaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transportation2Intent = new Intent(getApplicationContext(),Transportation2Activity.class);
                startActivity(transportation2Intent);
            }
        });
    }
}
