package com.tuv01.mediaplayert;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuv01 on 27.02.2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * Create a new SongAdapter object.
     *
     * @param activity is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs is the list of songs to be displayed.
     */
    public SongAdapter(@NonNull Context activity, ArrayList<Song> songs) {
        super(activity,0, songs);
    }
    public SongAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Song[] objects) {
        super(context, resource, objects);
    }

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Song[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Song> objects) {
        super(context, resource, textViewResourceId, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if an existing view is being reused, otherwise inflate the view
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //Get the Song object located at this position in this list
        Song currentSong = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID song_text_view
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        //Get the Song text from the currentSong object and set this text on the Song TextView
        songTextView.setText(currentSong.getSongText());

        //Find the TextView in the list_item.xml layout with the ID album_text_view
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        //Get the Album text from the currentSong object and set this text on the Album TextView
        albumTextView.setText(currentSong.getAlbumText());

        //Find the ImageView in the list_item.xml layout with the ID image
        ImageView albumImageView =(ImageView) listItemView.findViewById(R.id.song_album_image_view);
        //Check if an image is provided for this song or not
        if(currentSong.hasImage())
        {
            //If an image is available, display the provided image based on the resource ID
            albumImageView.setImageResource(currentSong.getImageResourceId());
            //Make sure the view is visible
            albumImageView.setVisibility(View.VISIBLE);
        }else{
            //Otherwise hide the ImageView (set visibility to GONE)
            albumImageView.setVisibility(View.GONE);
        }

        //Find the Button in the list_item.xml layout with the ID
        Button buttonToPlaying =(Button)listItemView.findViewById(R.id.play);

        //Return the whole list item layout (containing 2 TextViews,1 ImageView and 1 Button) so that it can
        //be shown in the ListView
        return listItemView;
    }
}