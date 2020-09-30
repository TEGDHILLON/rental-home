package com.example.myhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goHome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    boolean backpress = false;

    @Override
    public void onBackPressed() {
        if(backpress){
            super.onBackPressed();
        }
        this.backpress = true;
        Toast.makeText(getApplicationContext(),"Press Again to EXIT", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backpress=false;
            }
        },2000);
    }
}