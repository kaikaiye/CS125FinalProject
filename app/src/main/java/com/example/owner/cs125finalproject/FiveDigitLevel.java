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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiveDigitLevel extends AppCompatActivity {
    private static List<String> listOfDigits = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private String code;
    private ImageButton enter;
    private EditText inputCode;
    private ArrayList<String> submissions;
    private ArrayList<Character> isBull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_digit_level);
        Collections.shuffle(listOfDigits);
        code = listOfDigits.get(0) + listOfDigits.get(1) + listOfDigits.get(2) + listOfDigits.get(3) + listOfDigits.get(4);
        inputCode = findViewById(R.id.inputCode);
        inputCode.addTextChangedListener(digitInputWatcher);
        submissions = new ArrayList<>();
        isBull = new ArrayList<>();

        ImageButton reset =  findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restarted Level");
                Intent i = new Intent(FiveDigitLevel.this, FiveDigitLevel.class);
                startActivity(i);
            }
        });
        ImageButton quit = findViewById(R.id.quit_button);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Quit Game");
                Intent i = new Intent(FiveDigitLevel.this, HomePage.class);
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
                        /*************************************************
                         * Title: Toasts Overview
                         * Author: N/A
                         * Date: May 23, 2018
                         * Code version: N/A
                         * Availability: https://developer.android.com/guide/topics/ui/notifiers/toasts
                         **************************************************/
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
                    Log.d("Click:", code);
                    if (inputCode.getText().toString().equals(code)) {
                        enter.setEnabled(false);
                        endGameWin(numOfEnterClicks);
                    } else {
                        TextView bulls = findViewById(R.id.num_of_bulls);
                        String numOfBullAsString = ((Integer) getNumOfBulls()).toString();
                        bulls.setText(numOfBullAsString);
                        TextView cows = findViewById(R.id.num_of_cows);
                        String numOfCowsAsString = ((Integer) getNumOfCows()).toString();
                        cows.setText(numOfCowsAsString);
                    }
                }
                if (numOfEnterClicks >= 30) {
                    enter.setEnabled(false);
                    endGameLoss();
                }
            }
        });
    }
    /*************************************************
     * Title: How to use the TextWatcher class in Android?
     * Author: Dinesh Prajapati
     * Edited by: Suragch
     * Date: December 17, 2011
     * Edit Date: November 13, 2017
     * Code version: N/A
     * Availability: https://stackoverflow.com/questions/8543449/how-to-use-the-textwatcher-class-in-android
     **************************************************/
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
        char[] inputCodeAsArray = inputCode.getText().toString().toCharArray();
        if (inputCodeAsArray.length < 5) {
            enter.setEnabled(false);
        } else {
            enter.setEnabled(true);
        }
        for (int i = 0; i < inputCodeAsArray.length; i++) {
            for (int j = 0; j < inputCodeAsArray.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (inputCodeAsArray[i] == inputCodeAsArray[j]) {
                        Context context = getApplicationContext();
                        CharSequence text = "You have a repeating digit in your input!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        enter.setEnabled(false);
                    }
                }
            }
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
        Intent i = new Intent(FiveDigitLevel.this, GameEndLoss.class);
        startActivity(i);
    }
    private void endGameWin(int numOfSubmissions) {
        int score;
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
        /*************************************************
         * Title: How to pass integer from one Activity to another?
         * Author: Daniel Nyamasyo
         * Edited by: Benny
         * Date: August 28, 2016
         * Edit Date: November 12, 2017
         * Code version: N/A
         * Availability: https://stackoverflow.com/questions/7074097/how-to-pass-integer-from-one-activity-to-another/39187899
         **************************************************/
        Intent i = new Intent(FiveDigitLevel.this, GameEndWin.class);
        i.putExtra("score", score);
        startActivity(i);
    }
    private int getNumOfCows() {
        List<Character> codeAsArray = Arrays.asList(code.charAt(0), code.charAt(1), code.charAt(2), code.charAt(3), code.charAt(4));
        int numOfCows = 0;
        for (int i = 0; i < code.length(); i++) {
            if (codeAsArray.contains(inputCode.getText().toString().charAt(i))
                    && !isBull.contains(inputCode.getText().toString().charAt(i))) {
                numOfCows++;
            }
        }
        isBull.removeAll(isBull);
        return numOfCows;
    }
    private int getNumOfBulls() {
        int numOfBulls = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == inputCode.getText().toString().charAt(i)) {
                numOfBulls++;
                isBull.add(inputCode.getText().toString().charAt(i));
            }
        }
        return numOfBulls;
    }
}