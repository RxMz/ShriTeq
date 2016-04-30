package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login1 extends AppCompatActivity {
    String default1=null;
    EditText username1,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        username1=(EditText) findViewById(R.id.username1);
        pass=(EditText) findViewById(R.id.p1);
    }

    public void Login1func(View v)
    {
        SharedPreferences sharedPreferences= getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username", default1);
        String password= sharedPreferences.getString("password", default1);
        if(username.equals(default1) || password.equals(default1)) {
            Toast.makeText(Login1.this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(username1.getText().toString().trim().equals(username) && pass.getText().toString().trim().equals(password))
            {
                Intent intent=new Intent(getApplicationContext(), home1.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(Login1.this, "Wrong Password and Username", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

