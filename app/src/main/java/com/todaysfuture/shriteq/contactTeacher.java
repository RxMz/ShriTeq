package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class contactTeacher extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_teacher);
        Button rmcall=(Button)findViewById(R.id.btnCallRM);
        rmcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9910410355"));
                startActivity(intent);
            }
        });
        Button rmmessage=(Button)findViewById(R.id.btnMessageRM);
        rmmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             
                Uri uri = Uri.parse("smsto:" + "9810363914");
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));
            }
        });



    }
}

