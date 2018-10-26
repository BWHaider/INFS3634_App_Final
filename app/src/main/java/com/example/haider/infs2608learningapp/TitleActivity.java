package com.example.haider.infs2608learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        Button titleButton = (Button) findViewById(R.id.titleButton);
        titleButton.setOnClickListener(new View.OnClickListener() {
            //Opening screen is simply a splash page that leads into the contents page (which serves as the main activty for the user)
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }
    //splash creen with button that leads to main activity
    public void openMainActivity(){
        Intent mainActivityIntent = new Intent(this,MainActivity.class);
        startActivity(mainActivityIntent);
    }
}


