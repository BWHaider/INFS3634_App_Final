package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChapterFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_four);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button youtubeChapter3 = (Button)findViewById(R.id.youtubeChapter4);

        youtubeChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterFour.this, ChapterFourYoutubeActivity.class));
            }
        });

        Button quiz4Button = (Button)findViewById(R.id.quiz4Button);
        quiz4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterFour.this, ChapterFourQuiz.class));
            }
        });
    }
}