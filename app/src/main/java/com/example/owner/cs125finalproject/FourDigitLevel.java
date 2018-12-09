package com.example.owner.cs125finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourDigitLevel extends AppCompatActivity {
    private static List<Integer> listOfDigits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private int code;
    private ImageButton enter;
    private EditText inputCode;
    private ArrayList<String> submissions;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_digit_level);
        Collections.shuffle(listOfDigits);
        code = 1000*listOfDigits.get(0) + 100*listOfDigits.get(1) + 10*listOfDigits.get(2) + listOfDigits.get(3);
        inputCode = findViewById(R.id.inputCode);
        inputCode.addTextChangedListener(digitInputWatcher);
        submissions = new ArrayList<>();

        ImageButton reset =  findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restarted Level");
                Intent i = new Intent(FourDigitLevel.this, FourDigitLevel.class);
                startActivity(i);
            }
        });
        ImageButton quit = findViewById(R.id.quit_button);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Quit Game");
                Intent i = new Intent(FourDigitLevel.this, HomePage.class);
                startActivity(i);
            }
        });
        enter = findViewById(R.id.enter_button);
        enter.setEnabled(false);
        enter.setOnClickListener(new View.OnClickListener() {
            int numOfEnterClicks = 0;
            @Override
            public void onClick(View v) {
                if (enter.isEnabled()) {
                    if (submissions.contains(inputCode.getText().toString())) {
                        Context context = getApplicationContext();
                        CharSequence text = "This submission already exists!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        return;
                    }
                    addToSubmissions(inputCode.getText().toString());
                    displaySubmission();
                    numOfEnterClicks++;
                    Log.d("Click:", "Entered Code " + numOfEnterClicks);
                    Log.d("Click:", ((Integer) code).toString());
                    if (Integer.parseInt(inputCode.getText().toString()) == code) {
                        endGameWin(numOfEnterClicks);
                    }
                }
                if (numOfEnterClicks >= 30) {
                    enter.setEnabled(false);
                    endGameLoss();
                }
            }
        });
    }
    private TextWatcher digitInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkInputFields();
        }
    };
    private void checkInputFields() {
        String inputCodeAsString = inputCode.getText().toString();
        if (inputCodeAsString.length() < 4) {
            enter.setEnabled(false);
        } else {
            enter.setEnabled(true);
        }
    }
    private void displaySubmission() {
        TextView submissionsBox = findViewById(R.id.submissions_box);
        String lastTenSubmissions = "";
        int endIndex;
        if (submissions.size() > 10) {
            endIndex = submissions.size() - 10;
        } else {
            endIndex = 0;
        }
        for (int i = submissions.size() - 1; i >= endIndex; i--) {
            lastTenSubmissions += submissions.get(i) + "\n";
        }
        submissionsBox.setText(lastTenSubmissions);
    }
    private void addToSubmissions(String value) {
        submissions.add(value);
    }
    private void endGameLoss() {
        Intent i = new Intent(FourDigitLevel.this, GameEndLoss.class);
        startActivity(i);
    }
    private void endGameWin(int numOfSubmissions) {
        if (numOfSubmissions <= 12) {
            score = 100;
        } else if (numOfSubmissions <= 17) {
            score = 80;
        } else if (numOfSubmissions <= 22) {
            score = 60;
        } else if (numOfSubmissions <= 27) {
            score = 40;
        } else {
            score = 20;
        }
        Intent i = new Intent(FourDigitLevel.this, GameEndWin.class);
        i.putExtra("score", score);
        startActivity(i);
    }
}
