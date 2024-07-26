package com.example.uzhavu;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Timer extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 180000; // 3 minutes in milliseconds

    private Chronometer chronometer;
    private long PauseOffSet = 0;
    private boolean isPlaying = false;
    private ToggleButton toggleButton;
    private Button reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        toggleButton = findViewById(R.id.Toggle);
        //reset_btn = findViewById(R.id.reset_btn);

        toggleButton.setText(null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    chronometer.setBase(SystemClock.elapsedRealtime() + START_TIME_IN_MILLIS);
                    chronometer.start();
                    isPlaying = true;
                } else {
                    chronometer.stop();
                    PauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
                    isPlaying = false;
                }
            }
        });

        /*reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    chronometer.setBase(SystemClock.elapsedRealtime() + START_TIME_IN_MILLIS);
                    PauseOffSet = 0;
                    chronometer.start();
                    isPlaying = true;
                }
            }
        });*/
    }
}