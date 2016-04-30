package com.todaysfuture.shriteq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {
    static final String[] navdraweroptions= new String[]{"Home", "About Us", "Contact Us"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,Servce.class);
        startService(intent);
        ListView myNavList= (ListView) findViewById(R.id.drawer_list);
        myNavList.setAdapter(new NavigationArrayAdapter(this,navdraweroptions));
        myNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "You're already in home!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(MainActivity.this, ContactUs.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }
    public void Function(View v)
    {
        switch (v.getId())
        {
            case R.id.register:
                Intent intent=new Intent(getApplicationContext(), Register.class);
                startActivity(intent);break;
            case R.id.logn:  Intent intent1=new Intent(getApplicationContext(), Login1.class);
                startActivity(intent1);break;
            case  R.id.organize:  Intent intent2=new Intent(getApplicationContext(), Login.class);
                startActivity(intent2);break;
        }
    }
}

