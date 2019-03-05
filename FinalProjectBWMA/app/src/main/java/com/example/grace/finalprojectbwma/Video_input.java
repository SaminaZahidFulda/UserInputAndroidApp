package com.example.grace.finalprojectbwma;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

public class Video_input extends AppCompatActivity {
    private final int VIDEO_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);


    }

    public void videocapture(View view) {
        Intent camera_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file = getfilepath();
        Uri video_uri = Uri.fromFile(video_file);
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,video_uri);
        camera_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(camera_intent,VIDEO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == VIDEO_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"Video Successfully Recorded",Toast.LENGTH_LONG);
            }
            else {
                Toast.makeText(this,"Video Capture Failed..",Toast.LENGTH_LONG);
            }
        }
    }

    public File getfilepath() {
        File folder = new File("sdcard/video_app");
        if(!folder.exists()){
            folder.mkdir();
        }
        File video_file = new File(folder,"sample_video.mp4");
        return video_file;
    }

}
