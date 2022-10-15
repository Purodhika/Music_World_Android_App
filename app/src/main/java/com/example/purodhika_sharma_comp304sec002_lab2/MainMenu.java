package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.music_types, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_rock:
                Intent intentRock = new Intent(this, Rock.class);
                startActivity(intentRock);
                break;

            case R.id.menu_pop:
                Intent intentPop = new Intent(this, Pop.class);
                startActivity(intentPop);
                break;

            case R.id.menu_jazz:
                Intent intentJazz = new Intent(this, Jazz.class);
                startActivity(intentJazz);
                break;

            case R.id.menu_hiphop:
                Intent intentHiphop = new Intent(this, HipHop.class);
                startActivity(intentHiphop);
                break;


            case R.id.menu_indie:
                Intent intentIndie = new Intent(this, Indie.class);
                startActivity(intentIndie);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}