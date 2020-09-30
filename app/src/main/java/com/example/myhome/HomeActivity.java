package com.example.myhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.apartment) {
            startActivity(new Intent(this, Apartment.class));
        }
        if(id==R.id.detached) {
            startActivity(new Intent(this, Detached.class));
        }
        if(id==R.id.semidetached) {
            startActivity(new Intent(this, SemiDetached.class));
        }
        if(id==R.id.condominion) {
            startActivity(new Intent(this, Condominion.class));
        }
        if(id==R.id.townhouse) {
            startActivity(new Intent(this, TownHouse.class));
        }

        return super.onOptionsItemSelected(item);
    }


}