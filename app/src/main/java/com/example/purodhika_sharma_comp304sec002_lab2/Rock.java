package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Rock extends AppCompatActivity {
   ListView listingsList;
   ListAdapter listAdapter;
   SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock);

        //sharedPreferences.getSharedPreferences("info", MODE_PRIVATE);

        listingsList= (ListView)findViewById(R.id.listView);
        setTitle("Rock Music");
        ArrayList<Listings> genreArrayList=new ArrayList<>();
        genreArrayList.add(new Listings("Title: Wake Me Up", "\nArtist:Avicii", "\nPrice: $4"));
        genreArrayList.add(new Listings("Title: Comfortably Numb", "\nArtist:Pink Floyd", "\nPrice: $2"));
        genreArrayList.add(new Listings("Title: Nights", "\nArtist:Avicii", "\nPrice: $2"));


        listAdapter = new ListAdapter(this,genreArrayList);
        listingsList.setAdapter(listAdapter);

        listingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Toast.makeText(Rock.this, "Welcome to Rock Music", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(Rock.this,Rock.class);
                        startActivity(intent);
                }
                editor.commit();
            }
        });
    }

    public void enterSelectedScreen(View view)
    {
        Intent intent = new Intent(this, SelectedGenre.class);
        startActivity(intent);
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
