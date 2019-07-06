package com.example.jokes_viewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;

public class JokeViewerActivity extends AppCompatActivity {
    public static String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        TextView textview = (TextView) findViewById(R.id.joke_text);

        //Retrieve the joke from the Intent Extras
        String JokeResult = null;
        //the Intent that started us
        Intent intent = getIntent();
        JokeResult = intent.getStringExtra(getString(R.string.jokeEnvelope));

        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("we get find the joke!");
        }


    }
}