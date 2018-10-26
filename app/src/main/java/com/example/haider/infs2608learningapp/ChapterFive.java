package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChapterFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_five);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button youtubeChapter5 = (Button)findViewById(R.id.youtubeChapter5);

        youtubeChapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterFive.this, ChapterFiveYoutubeActivity.class));
            }
        });
        Button quiz5Button = (Button)findViewById(R.id.quiz5Button);
        quiz5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterFive.this, ChapterFiveQuiz.class));
            }
        });
    }
}
