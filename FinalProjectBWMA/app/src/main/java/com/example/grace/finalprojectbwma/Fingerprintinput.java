package com.example.grace.finalprojectbwma;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public class Fingerprintinput extends AppCompatActivity implements FingerPrintAuthCallback {

    private FingerPrintAuthHelper mFingerPrintAuthHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this, this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //start finger print authentication
        mFingerPrintAuthHelper.startAuth();
    }

    protected void onPause() {
        super.onPause();
        mFingerPrintAuthHelper.stopAuth();
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
    public void onNoFingerPrintHardwareFound() {
        Toast.makeText(this,"No FingerPrint Sensor found!!",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNoFingerPrintRegistered() {

    }

    @Override
    public void onBelowMarshmallow() {
        Toast.makeText(this,"Your device does not support finger prints",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        Toast.makeText(this,"Suceess",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        switch (errorCode) {    //Parse the error code for recoverable/non recoverable error.
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:
                //Cannot recognize the fingerprint scanned.
                Toast.makeText(this,"Cannot recognize the fingerprint scanned",Toast.LENGTH_SHORT).show();

                break;
            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                //This is not recoverable error. Try other options for user authentication. like pin, password.
                break;
            case AuthErrorCodes.RECOVERABLE_ERROR:
                //Any recoverable error. Display message to the user.
                break;
        }
    }
}
