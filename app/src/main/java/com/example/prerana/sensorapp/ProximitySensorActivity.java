package com.example.prerana.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximitySensorActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView tvProxi;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
        setTitle("Proximity sensor");
        
        tvProxi = findViewById(R.id.tvProx);
        proximity();
        
    }

    private void proximity() {

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener proxilistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(event.values[0] <= 4)
                {
                    tvProxi.setText("Object is near");

                }
                else{
                    tvProxi.setText("Object is far");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(proxilistener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
