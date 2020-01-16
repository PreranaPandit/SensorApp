package com.example.prerana.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button btnShowAll;
    private Button btnAccelrate;
    private  Button btnGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       btnShowAll = findViewById(R.id.btnDisplay);
       btnAccelrate = findViewById(R.id.btnAcceleration);
       btnGyro = findViewById(R.id.btnGyroscope);

       btnShowAll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });

       btnAccelrate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DashboardActivity.this, AccelerometerSensor.class);
               startActivity(intent);
           }
       });

       btnGyro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DashboardActivity.this, GyroscopeActivity.class);
               startActivity(intent);
           }
       });
    }
}
