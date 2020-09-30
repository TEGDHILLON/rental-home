package com.example.myhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class SemiDetached extends Activity {

    CheckBox cb1, cb2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_detached);

        cb1 = findViewById(R.id.cb);
        cb2 = findViewById(R.id.cb2);

        intent=new Intent(this, CheckOutActivity.class);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked()) {
                    Toast.makeText(SemiDetached.this, "Green Boulevard Selected", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(SemiDetached.this, "GB Deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb2.isChecked()) {
                    Toast.makeText(SemiDetached.this, "La Renaissance Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SemiDetached.this, "LR Deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void proceedToCheckout(View view) {
        if (!(cb1.isChecked()) && !(cb2.isChecked())){
            Toast.makeText(this, "Please visit any Home prior checkout", Toast.LENGTH_SHORT).show();
        }


        if (!cb1.isChecked()) {
            intent.removeExtra("GB");
        }
        if (!cb2.isChecked()){
            intent.removeExtra("LR");
        }

        if (cb1.isChecked() && cb2.isChecked()) {
            intent.putExtra("GB","Green Boulevard, $2500, Alberta");
            intent.putExtra("LR","La Renaissance, $3000, Quebec");
            startActivity(intent);
        } else  if (cb1.isChecked()) {
            intent.putExtra("GB","Green Boulevard, $2500, Alberta");
            startActivity(intent);
        } else if (cb2.isChecked()) {
            intent.putExtra("LR","La Renaissance, $3000, Quebec ");
            startActivity(intent);
        }

        if (!cb2.isChecked()){
            intent.removeExtra("LR");
        }
        if (!cb1.isChecked()) {
            intent.removeExtra("GB");
        }
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