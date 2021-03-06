package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameEndLoss extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_loss);
        Button main_menu = (Button) findViewById(R.id.main_menu_button);
        /*************************************************
         * Title: Android .ogg file stops playing after a few seconds
         * Author: Vadim Zin4uk
         * Date: October 8, 2014
         * Code version: N/A
         * Availability: https://stackoverflow.com/questions/24011610/android-ogg-file-stops-playing-after-a-few-seconds
         **************************************************/
        MediaPlayer losingSound = MediaPlayer.create(this, R.raw.losingsound);
        losingSound.start();

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Main Menu");
                Intent i = new Intent(GameEndLoss.this, HomePage.class);
                startActivity(i);
            }
        });
        ImageButton restart = (ImageButton) findViewById(R.id.restart_button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restart of game after game ended");
                Intent i = new Intent(GameEndLoss.this, Levels_Menu.class);
                startActivity(i);
            }
        });
    }
    /*************************************************
     * Title: Disable back button in android
     * Author: Gopinath
     * Date: January 24, 2011
     * Edit Date: December 13, 2017
     * Code version: N/A
     * Availability: https://stackoverflow.com/questions/4779954/disable-back-button-in-android
     **************************************************/
    public void onBackPressed() {
        Intent i = new Intent(GameEndLoss.this, Levels_Menu.class);
        startActivity(i);
    }
}
