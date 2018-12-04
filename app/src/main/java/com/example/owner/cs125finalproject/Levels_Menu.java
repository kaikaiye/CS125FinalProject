package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Levels_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_menu);
        Button level1 = (Button) findViewById(R.id.level1_button);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Level 1");
                Intent i = new Intent(Levels_Menu.this, ThreeDigitLevel.class);
                startActivity(i);
            }
        });
        Button level2 = (Button) findViewById(R.id.level2_button);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Level 2");
                Intent i = new Intent(Levels_Menu.this, ThreeDigitLevel.class);
                startActivity(i);
            }
        });
        Button level3 = (Button) findViewById(R.id.level3_button);
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Level 3");
                Intent i = new Intent(Levels_Menu.this, FourDigitLevel.class);
                startActivity(i);
            }
        });
        Button level4 = (Button) findViewById(R.id.level4_button);
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Level 4");
                Intent i = new Intent(Levels_Menu.this, FourDigitLevel.class);
                startActivity(i);
            }
        });
        Button level5 = (Button) findViewById(R.id.level5_button);
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Level 5");
                Intent i = new Intent(Levels_Menu.this, FiveDigitLevel.class);
                startActivity(i);
            }
        });
        Button challengeLevel = (Button) findViewById(R.id.challenge_level_button);
        challengeLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Start of Challenge Level");
                Intent i = new Intent(Levels_Menu.this, FiveDigitLevel.class);
                startActivity(i);
            }
        });
    }
}
