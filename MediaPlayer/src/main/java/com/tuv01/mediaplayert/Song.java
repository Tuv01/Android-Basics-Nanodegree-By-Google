package com.tuv01.mediaplayert;

/**
 * Created by Tuv01 on 27.02.2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Song represents a song that the user wants to reproduce.
 * It contains a song name, an album name, and an image for that album cover.
 */
public class Song extends AppCompatActivity{

    /** Song text */
    private String mptSongText;

    /** Album text */
    private String mptAlbumText;

    /** Image resource ID for the song */
    private int mptImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this song*/
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the song */
    private int mptAudioResourceId;

    /** Button play */
    private Button mptPlay;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        mptPlay = (Button) findViewById(R.id.play);
        mptPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), NowPlaying.class);
                startActivity(i);
            }
        });
    }

    /**
     * Create a new Song object.
     *
     * @param songText is tht song name for the audio file
     * @param albumText is the album name for the audio file
     */
    public Song(String songText, String albumText) {
        mptSongText = songText;
        mptAlbumText = albumText;
    }

    /**
     * Create a new Song object.
     *
     * @param songText is tht song name for the audio file
     * @param albumText is the album name for the audio file
     * @param imageResourceId is the drawable resource ID for the image associated with the song album cover
     */
    public Song(String songText, String albumText, int imageResourceId) {
        mptSongText = songText;
        mptAlbumText = albumText;
        mptImageResourceId = imageResourceId;
    }

    /**
     * Create a new Song object.
     *
     * @param songText is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param albumText is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the song album cover
     * @param audioResourceId is the resource ID for the audio file associated with this song
     */
    public Song(String songText, String albumText, int imageResourceId, int audioResourceId) {
        mptSongText = songText;
        mptAlbumText = albumText;
        mptImageResourceId = imageResourceId;
        mptAudioResourceId = audioResourceId;
    }
    /**
     * Get the song name.
     */
    public String getSongText() {
        return mptSongText;
    }

    /**
     * Get the Album name.
     */
    public String getAlbumText() {
        return mptAlbumText;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mptImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this song.
     */
    public boolean hasImage() {
        return mptImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the song.
     */
    public int getAudioResourceId() {
        return mptAudioResourceId;
    }
}