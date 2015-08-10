package com.example.foodrecipes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button btFb;
    private Button btGoogle;
    private Button btSkip;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btFb= (Button) findViewById(R.id.FbButton);
        btGoogle= (Button) findViewById(R.id.GoogleButton);
        btSkip= (Button) findViewById(R.id.SkipButton);
        btFb.setOnClickListener(this);
        btGoogle.setOnClickListener(this);
        btSkip.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        intent=new Intent(this,FoodGrid.class);
        startActivity(intent);
        finish();

    }
}
