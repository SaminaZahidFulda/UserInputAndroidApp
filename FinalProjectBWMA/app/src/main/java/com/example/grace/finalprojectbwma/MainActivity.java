package com.example.grace.finalprojectbwma;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button finger_btn;
    public Button voice_btn;
    public Button video_btn;
    public Button gesture_btn;
    public Button loc_btn;

    public void init(){
        finger_btn = (Button)findViewById(R.id.finger_btn);
        voice_btn = (Button)findViewById(R.id.voice_btn);
        video_btn = (Button)findViewById(R.id.video_btn);
        gesture_btn = (Button)findViewById(R.id.gesture_btn);
        loc_btn = (Button)findViewById(R.id.loc_btn);
        loc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loc_activity =  new Intent(MainActivity.this,User_location.class);
                startActivity(loc_activity);
            }
        });
        gesture_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gesture_activity =  new Intent(MainActivity.this,Gesture_input.class);
                startActivity(gesture_activity);
            }
        });
         video_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent videoactivity =  new Intent(MainActivity.this,Video_input.class);
                 startActivity(videoactivity);
             }
         });
        voice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voiceactivity =  new Intent(MainActivity.this,Voice_input.class);
                startActivity(voiceactivity);
            }
        });
        finger_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fingeractivity =  new Intent(MainActivity.this, Fingerprintinput.class);
                startActivity(fingeractivity);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


}
