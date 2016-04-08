package com.example.rydeldcosta.findme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class RestaurantAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Bundle bun = getIntent().getExtras();

        if(bun==null)
        {
            return;
        }
        else{
            String biteme = bun.getString("gotorest");
            TextView text2 = (TextView) findViewById(R.id.example);
            text2.setText("You are at " + biteme);
        }
    }

}
