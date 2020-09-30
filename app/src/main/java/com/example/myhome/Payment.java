package com.example.myhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends Activity {

    TextView payAmount;
    String amount,apt,emailid, emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Intent it; int Keyword1, Keyword2;
    EditText etName, etCardNum, etCVV, etPhone,etEmail,etFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payAmount = findViewById(R.id.payamount);

        etName = findViewById(R.id.etname);
        etCardNum = findViewById(R.id.etcardnum);
        etCVV = findViewById(R.id.etcvv);
        etPhone = findViewById(R.id.etphone);
        etEmail = findViewById(R.id.etemail);
        etFood = findViewById(R.id.etfood);

        it=getIntent();

        Keyword1 = it.getIntExtra("Credit",5);
        Keyword2 = it.getIntExtra("Debit",5);
        amount = it.getStringExtra("Amount");
        apt = it.getStringExtra("Apartment");
        if (Keyword1==0)
        {
            payAmount.setText("Use your Credit Card to pay "+amount);
        }
        else if (Keyword2==1)
        {
            payAmount.setText("Use your Debit Card to pay"+amount);
        }
        else
        {
            payAmount.setText("NULL");
        }
    }


    public void pay(View v) {
//        if(etName.getText().toString().trim().isEmpty() ||
//                etCardNum.getText().toString().trim().isEmpty() ||
//                etCVV.getText().toString().trim().isEmpty() ||
//                etPhone.getText().toString().trim().isEmpty() ||
//                etEmail.getText().toString().trim().isEmpty() ||
//                etFood.getText().toString().trim().isEmpty() )
//        {
//
//        }

        try{


        if (etName.getText().toString().trim().isEmpty()) {
            etName.setError("Name must not be Empty");
        }
        else if (etName.getText().toString().length() < 5 ){
            etName.setError("Enter your Full Name");
        }
        else if (etCardNum.getText().toString().trim().isEmpty()) {
            etCardNum.setError("Card Number must not be Empty");
        }
        else if (etCardNum.getText().toString().length() != 12 ){
            etCardNum.setError("Card Number must be of 12 digits");
        }
        else if (etCVV.getText().toString().trim().isEmpty()) {
            etCVV.setError("CVV must not be Empty");
        }
        else if (etCVV.getText().toString().length() != 3 ){
            etCVV.setError("CVV is 3 digits at the back of card");
        }
        else if (etPhone.getText().toString().trim().isEmpty()) {
            etPhone.setError("Phone Number must not be Empty");
        }
        else if (etPhone.getText().toString().length() != 10 ){
            etPhone.setError("Please enter 10 digit valid Phone Number");
        }
        else if (etEmail.getText().toString().trim().isEmpty()) {
            etEmail.setError("Email must not be Empty");
        }
        else if (!(etEmail.getText().toString().trim().matches(emailPattern))) {
            etEmail.setError("Invalid Email Address");
        }
        else if (etFood.getText().toString().trim().isEmpty()) {
            etFood.setError("Food must not be Empty");
        }

        else if (etName.getText().toString().trim().isEmpty() &&
                etCardNum.getText().toString().trim().isEmpty() &&
                etCVV.getText().toString().trim().isEmpty() &&
                etPhone.getText().toString().trim().isEmpty() &&
                etEmail.getText().toString().trim().isEmpty() &&
                etFood.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "One or More fields are empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Thanks for Booking " + apt + " !!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        }}catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}