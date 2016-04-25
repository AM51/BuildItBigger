package com.example.android.androidjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        TextView textView = (TextView)findViewById(R.id.jokeDisplay);
        textView.setText(joke);
    }
}
