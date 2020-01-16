package com.example.prerana.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {

    private EditText etAdd, etSubtract;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle("Gyroscope Sensor");

        etAdd = findViewById(R.id.etAdd);
        etSubtract = findViewById(R.id.etSubtract);

        sensorGyro();

    }

    private void sensorGyro() {

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyroListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(event.values[1] < 0)
                {
                    etAdd.setVisibility(View.VISIBLE);
                    etAdd.setText("Left");
                    etSubtract.setVisibility(View.GONE);
                }
                else if(event.values[1] > 0)
                {
                    etSubtract.setVisibility(View.VISIBLE);
                    etSubtract.setText("Right");
                    etAdd.setVisibility(View.GONE);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if(sensor != null)
        {
            sensorManager.registerListener(gyroListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        }
        else{
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}
