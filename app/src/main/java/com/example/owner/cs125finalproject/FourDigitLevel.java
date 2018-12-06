package com.example.owner.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class FourDigitLevel extends AppCompatActivity {
    private ImageButton enter;
    private EditText firstDigit;
    private EditText secondDigit;
    private EditText thirdDigit;
    private EditText fourthDigit;
    private ImageButton reset;
    private ImageButton quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_digit_level);
        reset =  findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click:","Restarted Level");
                Intent i = new Intent(FourDigitLevel.this, FourDigitLevel.class);
                startActivity(i);
            }
        });
        quit = findViewById(R.id.quit_button);
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
                    numOfEnterClicks++;
                    Log.d("Click:", "Entered Code " + numOfEnterClicks);
                }
                if (numOfEnterClicks >= 30) {
                    enter.setEnabled(false);
                }
            }
        });

        firstDigit = findViewById(R.id.first_digit_code);
        secondDigit = findViewById(R.id.second_digit_code);
        thirdDigit = findViewById(R.id.third_digit_code);
        fourthDigit = findViewById(R.id.fourth_digit_code);

        firstDigit.addTextChangedListener(digitInputWatcher);
        secondDigit.addTextChangedListener(digitInputWatcher);
        thirdDigit.addTextChangedListener(digitInputWatcher);
        fourthDigit.addTextChangedListener(digitInputWatcher);
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
        String firstDigitAsString = firstDigit.getText().toString();
        String secondDigitAsString = secondDigit.getText().toString();
        String thirdDigitAsString = thirdDigit.getText().toString();
        String fourthDigitAsString = fourthDigit.getText().toString();
        if (firstDigitAsString.isEmpty() || secondDigitAsString.isEmpty()
                || thirdDigitAsString.isEmpty() || fourthDigitAsString.isEmpty()) {
            enter.setEnabled(false);
        } else {
            enter.setEnabled(true);
        }
    }
}
