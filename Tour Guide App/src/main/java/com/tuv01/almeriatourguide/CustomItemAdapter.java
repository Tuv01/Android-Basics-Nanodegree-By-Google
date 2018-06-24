package com.tuv01.almeriatourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Tuv01 on 08.03.2018.
 */

public class CustomItemAdapter extends ArrayAdapter <CustomItem>{

    /**
     * Create a new CustomItemAdapter object.
     *
     * @param activity is the current context (i.e. Activity) that the adapter is being created in.
     * @param customItems is the list of custom's items to be displayed.
     */
    public CustomItemAdapter(@NonNull Context activity, ArrayList<CustomItem> customItems) {
        super(activity,0, customItems);
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
        //Get the CustomItem object located at this position in this list
        CustomItem currentCustomItem = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID description_text_view
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        //Get the CustomItem text from the currentCustomItem object and set this text on the description TextView
        descriptionTextView.setText(currentCustomItem.getAtgDescriptionText());

        //Find the TextView in the list_item.xml layout with the ID location_text_view
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        //Get the CustomItem text from the currentCustomItem object and set this text on the location TextView
        locationTextView.setText(currentCustomItem.getAtgLocationText());

        //Find the TextView in the list_item.xml layout with the ID price_text_view
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_text_view);
        //Get the CustomItem text from the currentCustomItem object and set this text on the location TextView
        priceTextView.setText(currentCustomItem.getAtgPriceText());


        //Find the ImageView in the list_item.xml layout with the ID photo_image_view
        ImageView photoImageView =(ImageView) listItemView.findViewById(R.id.photo_image_view);
        //Check if an image is provided for this song or not
        if(currentCustomItem.hasPhotoImage())
        {
            //If an image is available, display the provided image based on the resource ID
            photoImageView.setImageResource(currentCustomItem.getAtgPhotoId());
            //Make sure the view is visible
            photoImageView.setVisibility(View.VISIBLE);
        }else{
            //Otherwise hide the ImageView (set visibility to GONE)
            photoImageView.setVisibility(View.GONE);
        }

        //Find the ImageView in the list_item.xml layout with the ID price_image_view
        ImageView priceImageView =(ImageView) listItemView.findViewById(R.id.price_image_view);
        //Check if an image is provided for this song or not
        if(currentCustomItem.hasPriceImage())
        {
            //If an image is available, display the provided image based on the resource ID
            priceImageView.setImageResource(currentCustomItem.getAtgPriceImageId());
            //Make sure the view is visible
            priceImageView.setVisibility(View.VISIBLE);
        }else{
            //Otherwise hide the ImageView (set visibility to GONE)
            priceImageView.setVisibility(View.GONE);
        }

        //Find the ImageView in the list_item.xml layout with the ID location_image_view
        ImageView locationImageView =(ImageView) listItemView.findViewById(R.id.location_image_view);
        //Check if an image is provided for this song or not
        if(currentCustomItem.hasLocationImage())
        {
            //If an image is available, display the provided image based on the resource ID
            locationImageView.setImageResource(currentCustomItem.getAtgLocationImageId());
            //Make sure the view is visible
            locationImageView.setVisibility(View.VISIBLE);
        }else{
            //Otherwise hide the ImageView (set visibility to GONE)
            locationImageView.setVisibility(View.GONE);
        }

        //Return the whole list item layout (containing 3 TextViews and 3 ImageView) so that it can
        //be shown in the ListView
        return listItemView;
    }
}