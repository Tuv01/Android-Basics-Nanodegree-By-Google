package com.tuv01.almeriatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customitem_list, container, false);

        // Create a list of items-Restaurant
        ArrayList<CustomItem> customItems=new ArrayList<CustomItem>();
        customItems.add(new CustomItem(getResources().getString(R.string.salmantice),getResources().getString(R.string.calle_costa_balear),
                getResources().getString(R.string.ten),R.drawable.salmantice,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.catamaran),getResources().getString(R.string.playaalmadravillas),
                getResources().getString(R.string.fifteen),R.drawable.catamaran,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.tangobar),getResources().getString(R.string.callefelipe),
                getResources().getString(R.string.five),R.drawable.tango,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.tagliatella),getResources().getString(R.string.federicogarcia),
                getResources().getString(R.string.eight),R.drawable.latagliatella,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.aljaima),getResources().getString(R.string.jovellanos),
                getResources().getString(R.string.eight),R.drawable.aljaima,R.drawable.iprice,R.drawable.ilocation));
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