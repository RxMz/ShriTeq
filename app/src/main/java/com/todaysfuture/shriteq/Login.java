package com.todaysfuture.shriteq;

/**
 * Created by rishabh on 25/4/16.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=(EditText) findViewById(R.id.username);
        et2=(EditText) findViewById(R.id.pass1);
    }
    public void loginFunction(View view)
    {
        if(et1.getText().toString().equals("rishabhm") && et2.getText().toString().equals("tsrs123"))
        {
            Intent intent=new Intent(getApplicationContext(), home.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(Login.this, "Wrong Password or Username", Toast.LENGTH_SHORT).show();
        }

    }
}
