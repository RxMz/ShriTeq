package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public NavigationArrayAdapter(Context context, String[] values) {
        super(context, R.layout.basiclistformat, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.basiclistformat, parent, false);
        TextView textview = (TextView) rowview.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowview.findViewById(R.id.logo);
        textview.setText(values[position]);
        String s = values[position];
        if (s.equals("Home")) {
            imageView.setImageResource(R.drawable.home);
        }
        if (s.equals("Attendees")) {
            imageView.setImageResource(R.drawable.lol);
        }
        if (s.equals("Events")) {
            imageView.setImageResource(R.drawable.calender);
        }
        if (s.equals("Location")) {
            imageView.setImageResource(R.drawable.map);
        }
        if (s.equals("Keynote Speakers")) {
            imageView.setImageResource(R.drawable.speaker);
        }
        if(s.equals("Sponsors")) {
            imageView.setImageResource(R.drawable.sponsors);
        }
        if (s.equals("About Us")) {
            imageView.setImageResource(R.drawable.about);
        }
        if (s.equals("Contact Us")) {
            imageView.setImageResource(R.drawable.contact_us);
        }
        if(s.equals("Live Scores")){
            imageView.setImageResource(R.drawable.livescore);
        }
        return rowview;
    }
}
