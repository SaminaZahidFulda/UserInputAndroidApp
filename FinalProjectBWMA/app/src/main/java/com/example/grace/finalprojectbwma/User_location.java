package com.example.grace.finalprojectbwma;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.multidots.fingerprintauth.FingerPrintAuthHelper;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class User_location extends AppCompatActivity {
TextView textview;
Geocoder geocoder;
List<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Double lat =  50.557860299999994;
        Double lon = 9.6911158;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        textview = (TextView)findViewById(R.id.locationview);
        geocoder = new Geocoder(this, Locale.getDefault());
        try{
            addresses = geocoder.getFromLocation(lat,lon,1);
            String adress  = addresses.get(0).getAddressLine(0);
            String area  = addresses.get(0).getLocality();
            String city =  addresses.get(0).getAdminArea();
            String country =  addresses.get(0).getCountryName();
            String fulladdress = adress+" "+area+" "+city+" "+country;
            textview.setText(fulladdress);

        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

}
