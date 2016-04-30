package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Sponsors extends AppCompatActivity {
    static final String[] navdraweroptions= new String[]{"Home", "Attendees", "Events", "Location", "Keynote Speakers", "Sponsors","Live Scores","About Us","Contact Us"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        ListView myNavList= (ListView) findViewById(R.id.drawer_list);
        myNavList.setAdapter(new NavigationArrayAdapter(this, navdraweroptions));
        myNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://HOME

                        Intent i3 = new Intent(Sponsors.this, home1.class);
                        i3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i3);
                        break;
                    case 1://ABOUT
                        Intent i2 = new Intent(Sponsors.this, attend.class);
                        i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i2);
                        break;
                    case 2://INSTRUCTIONS
                        Intent i5 = new Intent(Sponsors.this, attend.class);
                        i5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i5);

                    case 3://SETTINGSUri gmmIntentUri = Uri.parse("geo:0,0?q=The+Shri+Ram+School,+Moulsari");
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=The+Shri+Ram+School,+Moulsari");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        break;
                    case 4:
                        //Keynote Speaker
                        Intent i4 = new Intent(Sponsors.this, keyspeakers.class);
                        i4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i4);
                        break;
                    case 5:
                        //The sponsors list
                        Toast.makeText(Sponsors.this, "You're already in this Page!", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Intent i6 = new Intent(Sponsors.this, LiveScore.class);
                        i6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(Sponsors.this, AboutUs.class);
                        i7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i7);
                        break;

                    case 8:
                        Intent i8 = new Intent(Sponsors.this, ContactUs.class);
                        i8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i8);
                        break;
                }
            }
        });
    }
}
