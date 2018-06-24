package com.tuv01.newssearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Tuv01 on 30.03.2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(@NonNull Context context, List<News> newsList) {
        super(context,0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView=convertView;
        if(listItemView==null){
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.news_list_item,parent,false);
        }
        // Find the earthquake at the given position in the list of earthquakes
        News currentNews=getItem(position);
        TextView titleTextView=(TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentNews.getWebTitle());
        TextView sectionTextView=(TextView)listItemView.findViewById(R.id.section);
        sectionTextView.setText(currentNews.getSectionName());
        TextView authorTextView=(TextView)listItemView.findViewById(R.id.author);
        authorTextView.setText(currentNews.getAuthor());
        TextView publicationdateTextView=(TextView)listItemView.findViewById(R.id.publicationdate);
        publicationdateTextView.setText(currentNews.getWebPublicationDate());
        return listItemView;
    }
}