package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerInfo extends AppCompatActivity {
    EditText userName;
    EditText userCardNumber;
    EditText userCardExpiry;
    EditText userCardCvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //String payment_method = preferences.getString("payment_method", "Cash");


        SharedPreferences selectedPref = getSharedPreferences("data", MODE_PRIVATE);

        //SharedPreferences.Editor editor= selectedPref.edit();
        //editor.putString("payment_method", "Cash");
        //editor.commit();

        String payment_method = selectedPref.getString("payment_method","Credit Card");
        TextView tvPaymentType = findViewById(R.id.paymentField);
        Toast.makeText(this, "Chosen mode of payment is " + payment_method, Toast.LENGTH_SHORT).show();
        //System.out.println(payment_method);
        //When method of payment is cash
        if (payment_method.equals("Cash")) {
            tvPaymentType.setText("Payment with Cash selected");
            EditText cardNumber = (EditText) findViewById(R.id.cardNumber);
            cardNumber.setVisibility(View.INVISIBLE);
            EditText cardExpiry = (EditText) findViewById(R.id.cardExpiry);
            cardExpiry.setVisibility(View.INVISIBLE);
            EditText cardCvv = (EditText) findViewById(R.id.cardCvv);
            cardCvv.setVisibility(View.INVISIBLE);
        }
        else if (payment_method.equals("Credit Card")) {
            tvPaymentType.setText("Please fill all the credit card details");

        }
        else if(payment_method.equals("Debit Card")){
            tvPaymentType.setText("Please fill all the debit card details");
        }
        else
        {
            Toast.makeText(this, "Choose a method of payment", Toast.LENGTH_SHORT).show();

        }
    }

    public void onClickPlaceOrder(View view) {
        if (validate() == true) {
            Toast toast = Toast.makeText(getApplicationContext(), "Payment Successful", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (validate() == false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please fill all fields correctly", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public boolean validate() {
        boolean error = false;
        userName = (EditText) findViewById(R.id.fullName);
        userCardNumber = (EditText) findViewById(R.id.cardNumber);
        userCardExpiry = (EditText) findViewById(R.id.cardExpiry);
        userCardCvv = (EditText) findViewById(R.id.cardCvv);

        if (userName.getText().toString().length() == 0)
        {
            Toast.makeText(this, "Name cannot be Null", Toast.LENGTH_SHORT).show();
            error= false;
        }
        else if(userCardCvv.getText().toString().length() != 3 )
        {
            Toast.makeText(this, "Enter 3-digit CVV", Toast.LENGTH_SHORT).show();
            error= false;
        }
              if(  userCardNumber.getText().toString().length() != 16 )
              {
                  Toast.makeText(this, "Enter your 16-Digit Card Number", Toast.LENGTH_SHORT).show();
                  error= false;
              }
              else if(userCardExpiry.getText().toString().length() != 4)
              {
                  Toast.makeText(this, "Enter 4-Digit Expiry Year", Toast.LENGTH_SHORT).show();
                  error= false;
        }
        else
        {
            error = true;
        }

        return error;
    }
}
