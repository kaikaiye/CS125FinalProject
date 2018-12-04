package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        Button main_menu = (Button) findViewById(R.id.main_menu_button);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Main Menu");
                Intent i = new Intent(GameEnd.this, HomePage.class);
                startActivity(i);
            }
        });
        ImageButton restart = (ImageButton) findViewById(R.id.restart_button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restart of game after game ended");
                Intent i = new Intent(GameEnd.this, Levels_Menu.class);
                startActivity(i);
            }
        });
    }
}
