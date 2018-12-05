package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        Button main_menu = (Button) findViewById(R.id.main_menu_button);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Returned to Main Menu");
                Intent i = new Intent(Instructions.this, HomePage.class);
                startActivity(i);
            }
        });
    }

}
