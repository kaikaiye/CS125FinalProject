package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button start = (Button) findViewById(R.id.start_game);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Started Game");
                Intent i = new Intent(HomePage.this, Levels_Menu.class);
                startActivity(i);
            }
        });
        Button rules = (Button) findViewById(R.id.rules_button);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Opened Rules");
                Intent i = new Intent(HomePage.this, Instructions.class);
                startActivity(i);
            }
        });
    }

}
