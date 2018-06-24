package com.tuv01.almeriatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class HotelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customitem_list, container, false);

        // Create a list of items-Restaurant
        ArrayList<CustomItem> customItems=new ArrayList<CustomItem>();
        customItems.add(new CustomItem(getResources().getString(R.string.nuevotorreluz),getResources().getString(R.string.plazaflores10),
                getResources().getString(R.string.thirtyfour),R.drawable.torreluz,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.tryp),getResources().getString(R.string.avmediterraneo),
                getResources().getString(R.string.fortyseven),R.drawable.trypindalo,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.catedral),getResources().getString(R.string.plazacatedral),
                getResources().getString(R.string.sixty),R.drawable.hotelcatedral,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.achotel),getResources().getString(R.string.plazaflores5),
                getResources().getString(R.string.fiftyfive),R.drawable.ac,R.drawable.iprice,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.nhhotel),getResources().getString(R.string.callejardin),
                getResources().getString(R.string.five),R.drawable.hotelnh,R.drawable.iprice,R.drawable.ilocation));
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