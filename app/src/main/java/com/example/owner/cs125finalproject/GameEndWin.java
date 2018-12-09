package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameEndWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_win);
        Button main_menu = findViewById(R.id.main_menu_button);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Main Menu");
                Intent i = new Intent(GameEndWin.this, HomePage.class);
                startActivity(i);
            }
        });
        ImageButton restart = findViewById(R.id.restart_button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restart of game after game ended");
                Intent i = new Intent(GameEndWin.this, Levels_Menu.class);
                startActivity(i);
            }
        });
        Intent intent = getIntent();
        String scoreReceivedFromLevel = ((Integer) intent.getIntExtra("score", 20)).toString();
        TextView totalScore = findViewById(R.id.total_score);
        totalScore.setText(scoreReceivedFromLevel);
    }
}
