package com.example.purodhika_sharma_comp304sec002_lab2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Listings> {

    //Reference: https://www.vogella.com/tutorials/AndroidListView/article.html

    public static List<Listings> selectedSongs = new ArrayList<>();

    private Context data;
    private List<Listings> songsList = new ArrayList<>();
    public ListAdapter(Context data, ArrayList<Listings> list){
        super(data, 0 , list);
        this.data = data;
        songsList = list;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem==null){
            listItem= LayoutInflater.from(data).inflate( R.layout.activity_listings,parent,false );
        }


        Listings genre=songsList.get( position );

        TextView tvTitle =(TextView)listItem.findViewById( R.id.textViewTitle );
        tvTitle.setText( genre.getTitle() );

        TextView tvArtist =(TextView)listItem.findViewById( R.id.textViewArtist );
        tvArtist.setText( genre.getArtist() );

        TextView tvPrice = (TextView)listItem.findViewById( R.id.textViewPrice );
        tvPrice.setText( genre.getPrice());


        final CheckBox checkBox = listItem.findViewById(R.id.checkboxlist);
        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked())
                {
                    SaveItem.selectedSongs.add(songsList.get( position ));
                }
                else
                {
                    SaveItem.selectedSongs.remove(songsList.get( position ));
                }

            }
        });

        return listItem;

    }


}