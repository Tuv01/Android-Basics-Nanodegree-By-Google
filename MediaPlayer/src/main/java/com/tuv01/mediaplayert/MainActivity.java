package com.tuv01.mediaplayert;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button nowplayingbutton;
    private Activity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentActivity=this;

        //Button now playing
        nowplayingbutton=(Button)findViewById(R.id.nowPlayingButton);
        final Intent intent =new Intent(getBaseContext(),NowPlaying.class);
        nowplayingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(currentActivity,intent);
            }

            private void startActivity(Activity currentActivity, Intent intent) {
                currentActivity.startActivity(intent);
            }
        });

        //Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Bury Me Alive", "Transmissions", R.drawable.throwthefight, R.raw.bury));
        songs.add(new Song("The Call of The Mountains", "Origins", R.drawable.thecallofthe));
        songs.add(new Song("Sail", "Winter Kills", R.drawable.sail));
        songs.add(new Song("This Probably Won't End Well", "The Order of Things", R.drawable.thisprobably));
        songs.add(new Song("Born Young and Free", "The Weird and Wonderful", R.drawable.bornyoungandfree));
        songs.add(new Song("Denial", "We are Harlot", R.drawable.denial));
        songs.add(new Song("Interlude", "Interlude", R.drawable.interlude));
        songs.add(new Song("Freebird", "Salute", R.drawable.freebird));

        //Create an SongAdapter, whose data source is a list of songs.
        SongAdapter adapter = new SongAdapter(this, R.layout.list_item, songs);

        //song_list.xml layout file
        ListView listView = (ListView) findViewById(R.id.list);

        //Make the ListView use the SongAdapter so that the ListView will display list items for
        //each Song in the list
        listView.setAdapter(adapter);
    }
}