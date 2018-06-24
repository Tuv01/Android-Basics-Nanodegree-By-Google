package com.tuv01.mediaplayert;

import android.content.Intent;
import android.media.MediaPlayer; //MediaPlayer API
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

public class NowPlaying extends AppCompatActivity {

    //MediaPlayer API use to reproduce audio and video files.
    private MediaPlayer mediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Button play, pause and stop
        final Button pauseButton =(Button)findViewById(R.id.buttonpause);
        final Button playButton =(Button)findViewById(R.id.buttonplay);
        final Button stopButton=(Button)findViewById(R.id.buttonstop);
        stopButton.setAlpha(0.50f);

        // Release the media player if it currently exists because we are about to
        // play a different sound file
        releaseMediaPlayer();

        //MediaPlayer API
         mediaPlayer=MediaPlayer.create(getBaseContext(),R.raw.bury);

        //If click on the Button play the audio.file and change the visibility of the Buttons
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                playButton.setAlpha(1.0f);
                pauseButton.setAlpha(0.50f);
                stopButton.setAlpha(1.0f);
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        //If click on the Button pause the audio.file and change the visibility of the Buttons
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                pauseButton.setAlpha(1.0f);
                playButton.setAlpha(0.50f);
            }
        });

        //If click on the Button stop the audio.file and change the visibility of the Buttons
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stopButton.setAlpha(0.50f);
                pauseButton.setAlpha(0.50f);
                playButton.setAlpha(1.0f);
            }
        });

        //If click on the Button PlayList 1)stop the music 2)Change to the playlist activity.
        Button playlistbutton=(Button)findViewById(R.id.playlistButton2);
        playlistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NowPlaying.this,MainActivity.class);
                mediaPlayer.stop();
                startActivity(intent);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}