package com.tuv01.almeriatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class MonumentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customitem_list, container,false);

        // Create a list of items-Restaurant
        final ArrayList<CustomItem> customItems=new ArrayList<CustomItem>();
        //Add item to the ArrayList<CustomItem>  String description,String location,String price,int Photoid,int PriceImageId,int LocationImageId
        String free=getResources().getString(R.string.free);
        String almanzor=getResources().getString(R.string.callealmanzor);
        customItems.add(new CustomItem(getResources().getString(R.string.alcalzaba),almanzor,
                free,R.drawable.alcalzaba,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.alcalzabagardens),almanzor,
                free,R.drawable.gardens,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.alcalzabawalls),almanzor,
                free,R.drawable.walls,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.alcalzabatower),almanzor,
                free,R.drawable.defensive,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.alcalzabagatehouse),almanzor,
                free,R.drawable.gatehouse,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.mauthausen),getResources().getString(R.string.almadrabillas),
                free,R.drawable.mauthausen,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.caridad),getResources().getString(R.string.ramblabelen),
                free,R.drawable.caridad,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.diezmocastle),getResources().getString(R.string.diezmostreet),
                free,R.drawable.castillodeldiezmo,R.drawable.iprice,R.drawable.ilocation));

        // Create an CustomItemAdapter}, whose data source is a list of customItems. The
        // adapter knows how to create list items for each item in the list.
        CustomItemAdapter adapter = new CustomItemAdapter(getActivity(), customItems);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called list, which is declared in the
        // customitem_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the CustomItemAdapter we created above, so that the
        // ListView will display list items for each CustomItem in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}