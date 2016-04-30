package com.todaysfuture.shriteq;

import android.app.Activity;

/**
 * Created by rishabh on 25/4/16.
 */import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextView school, p1, username, password, confirm;
    String schoolname;
    Boolean bool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        school = (TextView) findViewById(R.id.school);
        p1 = (TextView) findViewById(R.id.p1);
        username = (TextView) findViewById(R.id.p2);
        password = (TextView) findViewById(R.id.p3);
        confirm = (TextView) findViewById(R.id.p4);
    }

    public void RegisterFunction(View v) {
        schoolname = school.getText().toString();
        SharedPreferences participants = getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = participants.edit();
        editor.putString("p1", p1.getText().toString());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());

        if (password.getText().toString().equals(confirm.getText().toString())) {
            editor.commit();
            Toast.makeText(Register.this, "Registration Successful! Please Login now", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(Register.this, "Passwords do not match!Please try again!", Toast.LENGTH_SHORT).show();
            password.setText("");
            confirm.setText("");
        }


    }
}