package com.tuv01.almeriatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class BeachFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customitem_list, container, false);

        // Create a list of items-Restaurant
        ArrayList<CustomItem> customItems=new ArrayList<CustomItem>();
        String animal=getResources().getString(R.string.animal);
        String noanimal=getResources().getString(R.string.noanimal);
        String nudism=getResources().getString(R.string.nudism);
        customItems.add(new CustomItem(getResources().getString(R.string.playazapillo),getResources().getString(R.string.almeria),
                animal,R.drawable.zapillo,R.drawable.idog,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.playaaguadulce),getResources().getString(R.string.aguadulce),
                animal,R.drawable.aguadulce,R.drawable.idog,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.playaroquetas),getResources().getString(R.string.roquetas),
                noanimal,R.drawable.roquetas,R.drawable.inoanimal,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.playacabo),getResources().getString(R.string.cabodegata)
                ,nudism,R.drawable.cabodegata,R.drawable.inudism,R.drawable.ilocation));
        customItems.add(new CustomItem(getResources().getString(R.string.playasanjose),getResources().getString(R.string.sanjose),
                nudism,R.drawable.sanjose,R.drawable.inudism,R.drawable.ilocation));

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