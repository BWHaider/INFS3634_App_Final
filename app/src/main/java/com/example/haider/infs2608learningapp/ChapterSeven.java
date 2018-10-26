package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChapterSeven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_seven);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button youtubeChapter7 = (Button)findViewById(R.id.youtubeChapter7);

        youtubeChapter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterSeven.this, ChapterSevenYoutubeActivity.class));
            }
        });

        Button quiz7Button = (Button)findViewById(R.id.quiz7Button);
        quiz7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterSeven.this, ChapterSevenQuiz.class));
            }
        });
    }
}
