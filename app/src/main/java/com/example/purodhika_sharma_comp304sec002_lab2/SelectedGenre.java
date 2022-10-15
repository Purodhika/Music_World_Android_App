package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectedGenre extends AppCompatActivity {
    int sum = 0;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_genre);

        RadioGroup radioGroup = findViewById(R.id.rdBtnGroup);
        for (final Listings song : SaveItem.selectedSongs)
        {
            RadioButton radioButton = new RadioButton(this);
            String price = song.getPrice();
            String a = totalPrice(price);
            //System.out.println(a);
            int total =  Integer.parseInt(a);
            sum = sum + total ;

            radioButton.setId(index++);
            radioButton.setText(song.getTitle()+" "+song.getArtist()+" "+song.getPrice());
            //System.out.println(sum);

            TextView textView = (TextView) findViewById(R.id.totalPrice);
            textView.setText("Your total price is " +Integer.toString(sum));


            radioGroup.addView(radioButton);

        }
    }

    public String totalPrice(String str){
        for (int i = 0 ; i < str.length() ; i++){
            int j = 0;
            if(str.charAt(i) == '$'){
                j = i;
            }
            str = str.substring(j+1);
        }
        return str;
    }

    public void onClickDelete(View view)
    {
        int x = 0;
        String z = "";
        RadioGroup radioGroup = findViewById(R.id.rdBtnGroup);
        int a = radioGroup.getCheckedRadioButtonId();
        RadioButton rbtn = findViewById(a);
        String text = (String) rbtn.getText();
        String price = totalPrice(text);
        price = price.substring(price.length() - 1);
        x = Integer.parseInt(price);
        sum = sum - x;
        radioGroup.removeViewAt(a);
        TextView textView = (TextView) findViewById(R.id.totalPrice);
        textView.setText("Your total price is " +Integer.toString(sum));
    }

    public void Proceed_Payment(View view)
    {
       Intent intent = new Intent(this, Checkout.class);
       startActivity(intent);
    }
}