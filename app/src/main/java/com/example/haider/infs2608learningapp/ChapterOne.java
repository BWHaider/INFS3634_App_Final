package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChapterOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//toolbar for ui purposes and to hold elements
        //Button that leads to the youtube video for the chapter
        Button youtubeChapter1 = (Button)findViewById(R.id.youtubeChapter1);

        youtubeChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterOne.this, ChapterOneYoutubeActivity.class));
            }
        });
        //Button that leads to the quiz with questions specifc to the chapter
        Button quiz1Button = (Button)findViewById(R.id.quiz1Button);

        quiz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterOne.this, ChapterOneQuiz.class));
            }
        });
    }
}
