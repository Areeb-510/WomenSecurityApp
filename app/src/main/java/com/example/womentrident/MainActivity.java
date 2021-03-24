package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccelerometerSensorAvailable;
    private float currentX,currentY,currentZ;
    private float lastX,lastY,lastZ;
    private boolean itisnotfirsttime=false;
    private float xDifference,yDifference,zDifference;
    private float shakeThreshold=15f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null)
        {
            accelerometerSensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvailable=true;

        }else{
            isAccelerometerSensorAvailable=false;
        }

    }

    public void Callforhelp(View view) {
        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);
    }

    public void CallHelpActivity(View view) {
        Intent intent = new Intent(MainActivity.this,HelplineActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        currentX= sensorEvent.values[0];
        currentY=sensorEvent.values[1];
        currentZ=sensorEvent.values[2];

        if(itisnotfirsttime)
        {
             xDifference = Math.abs(lastX-currentX);
             yDifference = Math.abs(lastY-currentY);
             zDifference= Math.abs(lastZ- currentZ);

             if((xDifference>shakeThreshold&& yDifference>shakeThreshold)||(xDifference>shakeThreshold&&zDifference>shakeThreshold)||(yDifference>shakeThreshold&&zDifference>shakeThreshold))
             {
                 Intent intent = new Intent(MainActivity.this,HelplineActivity.class);
                 startActivity(intent);
             }
        }

        lastX = currentX;
        lastY = currentY;
        lastZ = currentZ;
        itisnotfirsttime=true;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(isAccelerometerSensorAvailable)
            sensorManager.registerListener(this,accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAccelerometerSensorAvailable)
            sensorManager.unregisterListener(this);
    }

    public void addNumber(View view) {

        Intent intent = new Intent(MainActivity.this,addNumbers.class);
        startActivity(intent);
    }
}