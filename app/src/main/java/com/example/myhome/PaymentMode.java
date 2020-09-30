package com.example.myhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentMode extends Activity {

    RadioGroup rdg;
    RadioButton rdbt1, rdbt2, rdbt3;
    Button bt;
    Intent it;
    String str,apt;
    TextView TvCashPayment,TvPayAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_mode);

        rdg = findViewById(R.id.rdgrp);

        rdbt1 = findViewById(R.id.rbcash);
        rdbt2 = findViewById(R.id.rbcredit);
        rdbt3 = findViewById(R.id.rbdebit);

        bt = findViewById(R.id.btProceedToPay);

        TvCashPayment = findViewById(R.id.cashpayment);
        TvPayAmount = findViewById(R.id.payamount);
        try {
            it=getIntent();
            str = it.getStringExtra("Amount");
            apt = it.getStringExtra("Apartment");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            TvPayAmount.setText("Amount to be Paid is: " + str);
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        rdbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PaymentMode.this, "Cash Payment Mode Selected", Toast.LENGTH_SHORT).show();
            }
        });

        rdbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                str =  (it.getStringExtra("Cash"));
//                if(str!=null) it.removeExtra("Cash");
//
//
//                str =  (it.getStringExtra("Debit"));
//                if(str!=null) it.removeExtra("Debit");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TvCashPayment.setText("");
                    }
                });

                Toast.makeText(PaymentMode.this, "Credit Card Mode Selected", Toast.LENGTH_SHORT).show();
            }
        });
        rdbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TvCashPayment.setText("");
                    }
                });
                Toast.makeText(PaymentMode.this, "Debit Card Mode Selected", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void proceedToPay(View view) {

        if(rdbt1.isChecked())
        {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TvCashPayment.setText("Please pay the cash and notify the owner!");
                }
            });

        }

        else if(rdbt2.isChecked())
        {
            it = new Intent(this, Payment.class);
            it.putExtra("Credit",0);
            it.putExtra("Amount",str);
            it.putExtra("Apartment",apt);
            startActivity(it);
        }

        else if(rdbt3.isChecked())
        {
            it = new Intent(this, Payment.class);
            it.putExtra("Debit",1);
            it.putExtra("Amount",str);
            it.putExtra("Apartment",apt);
            startActivity(it);
        }
        
        else {
            Toast.makeText(this, "Choose any Payment Mode", Toast.LENGTH_LONG).show();
        }




    }
}