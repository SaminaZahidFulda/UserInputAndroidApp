package com.example.grace.gestureinput;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener
{
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gesturetext.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gesturetext.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gesturetext.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gesturetext.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gesturetext.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gesturetext.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gesturetext.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gesturetext.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gesturetext.setText("onFling");
        return true;
    }

    private TextView gesturetext;
    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gesturetext = (TextView) findViewById(R.id.gesturetext);
        this.gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setOnDoubleTapListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
