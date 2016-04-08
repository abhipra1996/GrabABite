package com.example.rydeldcosta.findme;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void onBite(View v)
    {
        TextView tx = (TextView) findViewById(R.id.mytext);
        if(tx.getText().toString().equals("Bite me"))
        {
            Context context = getApplicationContext();
            CharSequence text = "Please Select a restaurant!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            Intent i = new Intent(this, RestaurantAct.class);
            String msg = tx.getText().toString();
            i.putExtra("gotorest", msg);
            startActivity(i);
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Marker source;

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng malik = new LatLng(25.428190, 81.770655);
       source =  mMap.addMarker(new MarkerOptions().position(malik).title("Malik Dhaba"));
        LatLng sanskar = new LatLng(25.428748, 81.770461);
        mMap.addMarker(new MarkerOptions().position(sanskar).title("Sanskar"));
        LatLng sonu = new LatLng(25.4272, 81.7718);
        mMap.addMarker(new MarkerOptions().position(sonu).title("Sonu Night Canteen"));
        LatLng punjabi = new LatLng(25.4303, 81.7675 );
        mMap.addMarker(new MarkerOptions().position(punjabi).title("Punjabi Dhaba"));
        LatLng ranu = new LatLng(25.4278, 81.7714);
        mMap.addMarker(new MarkerOptions().position(ranu).title("Ranu Night Canteen"));
        LatLng caf = new LatLng(25.431234, 81.771908 );
        mMap.addMarker(new MarkerOptions().position(caf).title("Cafeteria"));
        LatLng OC = new LatLng(25.428724, 81.7723 );
        mMap.addMarker(new MarkerOptions().position(OC).title("Old Canteen"));

        //markerclick event

        mMap.setOnMarkerClickListener(this);
        LatLngBounds IIITA = new LatLngBounds(
                new LatLng(25.429173, 81.765801), new LatLng(25.430817, 81.777005));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(IIITA.getCenter(), 16));
        mMap.moveCamera(CameraUpdateFactory.zoomBy(20));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malik));
        mMap.setMyLocationEnabled(true);
    }

    @Override

    public boolean onMarkerClick(Marker marker) {
        TextView mytext = (TextView) findViewById(R.id.mytext);
        mytext.setText(marker.getTitle());
        return true;
    }
}
