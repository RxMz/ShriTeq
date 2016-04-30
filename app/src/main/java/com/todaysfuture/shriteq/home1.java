package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class home1 extends AppCompatActivity {
    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;
    static final String[] navdraweroptions= new String[]{"Home", "Attendees", "Events", "Location", "Keynote Speakers", "Sponsors","Live Scores","About Us","Contact Us"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        ListView myNavList= (ListView) findViewById(R.id.drawer_list);
        myNavList.setAdapter(new NavigationArrayAdapter(this, navdraweroptions));
        myNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://HOME
                        Toast.makeText(home1.this, "You're already in home!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1://ABOUT
                        Intent i2 = new Intent(home1.this, attend.class);
                        i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i2);
                        break;
                    case 2://INSTRUCTIONS
                        Intent i3 = new Intent(home1.this, events.class);
                        i3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i3);
                        break;
                    case 3://SETTINGSUri gmmIntentUri = Uri.parse("geo:0,0?q=The+Shri+Ram+School,+Moulsari");
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=The+Shri+Ram+School,+Moulsari");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        break;
                    case 4:
                        //Keynote Speaker
                        Intent i4 = new Intent(home1.this, keyspeakers.class);
                        i4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i4);
                        break;
                    case 5:
                        //The sponsors list
                        Intent i5 = new Intent(home1.this, Sponsors.class);
                        i5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(home1.this, LiveScore.class);
                        i6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(home1.this, AboutUs.class);
                        i7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i7);
                        break;

                    case 8:
                        Intent i8 = new Intent(home1.this, ContactUs.class);
                        i8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i8);
                        break;
                }
            }
        });

        initUI();
        countDownStart();


    }

    @SuppressLint("SimpleDateFormat")
    private void initUI() {
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        tvDay = (TextView) findViewById(R.id.txtTimerDay);
        tvHour = (TextView) findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) findViewById(R.id.txtTimerSecond);
    }

    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Here Set your Event Date
                    Date futureDate = dateFormat.parse("2016-10-13");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        tvDay.setText("" + String.format("%02d", days));
                        tvHour.setText("" + String.format("%02d", hours));
                        tvMinute.setText("" + String.format("%02d", minutes));
                        tvSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        tvEvent.setText("Android Event Start");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    // //////////////COUNT DOWN END/////////////////////////
}

