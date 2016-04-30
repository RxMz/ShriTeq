package com.todaysfuture.shriteq;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;

/**
 * Created by rishabh on 25/4/16.
 */
public class LiveScore extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_scores);
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
        query.getInBackground("4ZUBo6EePk", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, com.parse.ParseException e) {
                if(e==null){
                    TextView tv=(TextView)findViewById(R.id.score1);
                    tv.setText((CharSequence) object);
                }
            }

        });


    }
}
