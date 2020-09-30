package com.example.myhome;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CheckOutActivity extends Activity {

    RadioGroup radioGroup;
    RadioButton rb, rb2;
    Intent itdata; Boolean flag1 = false,flag2 = false;
    TextView TVCheckName, TVPrice, TVServiceTax, TVTotal, TextCheckout, TextPrice,TextServiceTax,TextTotal;
    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        TextCheckout = findViewById(R.id.checkout);
        TextPrice = findViewById(R.id.checkPrice);
        TextServiceTax = findViewById(R.id.checkServiceTax);
        TextTotal= findViewById(R.id.checkTotal);

        TVCheckName = findViewById(R.id.checkName);
        TVPrice = findViewById(R.id.price);
        TVServiceTax = findViewById(R.id.serviceTax);
        TVTotal = findViewById(R.id.total);

        TVCheckName.setText(null);
        TVPrice.setText(null);
        TVServiceTax.setText(null);
        TVTotal.setText(null);

        radioGroup = (RadioGroup)findViewById(R.id.rdgrp);
        //===============================================
//        try{
            itdata = getIntent();
            //itdata.getStringExtra("GB").length()==0

            if (itdata.getStringExtra("GB")==null)
            {
                flag1=false;
                Toast.makeText(this, "GB is null", Toast.LENGTH_SHORT).show();
            }else{
                rb = new RadioButton(this);
                rb.setId(View.generateViewId());
                rb.setText(itdata.getStringExtra("GB"));
                radioGroup.addView(rb);
                flag1 = true;
            }

            if (itdata.getStringExtra("LR")==null)
            {
                flag2=false;
                Toast.makeText(this, "LR is null", Toast.LENGTH_SHORT).show();
            }else{
                rb2 = new RadioButton(this);
                rb2.setId(View.generateViewId());
                rb2.setText(itdata.getStringExtra("LR"));
                radioGroup.addView(rb2);
                flag2=true;
                }
//            }catch (Exception e){ e.printStackTrace();
//        Toast.makeText(this, e+"", 5000).show();
//        }
        //===============================================

        try {
            if(flag1){
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TVCheckName.setText(": Green Boulevard");
                            TVPrice.setText(" :$2500");
                            TVServiceTax.setText(": $500");
                            TVTotal.setText(": $3000");
                        }
                    });
                }
            }); }

            if(flag2){
            rb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TVCheckName.setText(": La Renaissance");
                            TVPrice.setText(": $3000");
                            TVServiceTax.setText(": $500");
                            TVTotal.setText(": $3500");
                        }
                    });
                }
            });
        }}catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkout(View view) {

        if (flag1==true && flag2==true )
        {
            if(rb.isChecked() || rb2.isChecked())
            {
                Intent it = new Intent(getApplicationContext(), PaymentMode.class);
                it.putExtra("Amount", TVTotal.getText().toString());
                it.putExtra("Apartment", TVCheckName.getText().toString());
                startActivity(it);
            }
            else Toast.makeText(this, "Choose Any Apartment for Payment !!", Toast.LENGTH_SHORT).show();
        }
        else if (flag1)
        {
            if (rb.isChecked())
            {
                Intent it = new Intent(getApplicationContext(), PaymentMode.class);
                it.putExtra("Amount", TVTotal.getText().toString());
                it.putExtra("Apartment", TVCheckName.getText().toString());
                startActivity(it);
            }
            else Toast.makeText(this, "Choose Green Boulevard for Paymnent", Toast.LENGTH_SHORT).show();

        } else if (flag2)
        {
            if (rb2.isChecked())
            {
                Intent it = new Intent(getApplicationContext(), PaymentMode.class);
                it.putExtra("Amount", TVTotal.getText().toString());
                it.putExtra("Apartment", TVCheckName.getText().toString());
                startActivity(it);
            }
            else Toast.makeText(this, "Choose La Renaissance for Paymnent", Toast.LENGTH_SHORT).show();
        }
    }
}



