package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.contentsList);
        //each item in the list view is a different chapter covering the course of INFS2608
        String[] values = new String[]{
                "Chapter One: File Based Systems to Big Data", "Chapter Two: Advanced SQL", "Chapter Three:  Database System Development Lifecyle",
                "Chapter Four: Relational Model and Relational Algebra", "Chapter Five: Data Security", "Chapter Six: Transaction Management",
                "Chapter Seven: Data and the Internet", "Chapter Eight: Data Warehousing Mining Analytics", "Chapter Nine: Big Data", "Quiz"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);
//set on click listener that leads to each chapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //set on click listener makes each item clickable and opens a new scrollable activty for each page
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent chapterOneIntent = new Intent(view.getContext(), ChapterOne.class);
                    startActivityForResult(chapterOneIntent, 0);

                }
                if (position==1){
                    Intent chapterTwoIntent = new Intent(view.getContext(), ChapterTwo.class);
                    startActivityForResult(chapterTwoIntent, 0);

                }
                if (position==2) {
                    Intent chapterThreeIntent = new Intent(view.getContext(), ChapterThree.class);
                    startActivityForResult(chapterThreeIntent, 0);
                }
                if (position==3) {
                    Intent chapterFourIntent = new Intent(view.getContext(), ChapterFour.class);
                    startActivityForResult(chapterFourIntent, 0);
                }
                if (position==4) {
                    Intent chapterFiveIntent = new Intent(view.getContext(), ChapterFive.class);
                    startActivityForResult(chapterFiveIntent, 0);
                }
                if (position==5) {
                    Intent chapterSixIntent = new Intent(view.getContext(), ChapterSix.class);
                    startActivityForResult(chapterSixIntent, 0);
                }
                if (position==6) {
                    Intent chapterSevenIntent = new Intent(view.getContext(), ChapterSeven.class);
                    startActivityForResult(chapterSevenIntent, 0);
                }
                if (position==7) {
                    Intent chapterEightIntent = new Intent(view.getContext(), ChapterEight.class);
                    startActivityForResult(chapterEightIntent, 0);
                }
                if (position==8) {
                    Intent chapterNineIntent = new Intent(view.getContext(), ChapterNine.class);
                    startActivityForResult(chapterNineIntent, 0);
                }
                if (position==9) {
                    Intent quizIntent = new Intent(view.getContext(), MainQuiz.class);
                    startActivityForResult(quizIntent, 0);
                }
            }
        });

    }
}
