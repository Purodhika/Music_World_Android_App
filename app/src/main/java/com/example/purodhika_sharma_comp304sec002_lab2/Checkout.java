package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
    }
    public void onClickPayment(View view)
    {
        RadioGroup radioGroup = findViewById(R.id.rg_payment);

        //extracting the selected radiobutton from group
        int selectedPaymentMethod = radioGroup.getCheckedRadioButtonId();

        //Ensuring an option is selected
        if(selectedPaymentMethod==-1)
        {
            Toast.makeText(this, "Choose a valid payment option", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //locating selected radiobutton
            RadioButton radioButton = (RadioButton) findViewById(selectedPaymentMethod);
            String payment_option = (String) radioButton.getText();

            SharedPreferences paymentPreference = getSharedPreferences("info", 0);
            SharedPreferences.Editor paymentEditor = paymentPreference.edit();

            //storing payment method
            paymentEditor.putString("payment_option", payment_option);

            //committing the input
            paymentEditor.commit();

            //taking user to fill info
            Intent intent = new Intent(this, CustomerInfo.class);
            startActivity(intent);
        }
    }
}