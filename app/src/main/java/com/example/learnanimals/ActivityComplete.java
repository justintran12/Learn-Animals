package com.example.learnanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class ActivityComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int numCorr = intent.getIntExtra(MainActivity.AMOUNT_CORRECT, -1);

        String result = "You got " + numCorr + " out of " + MainActivity.SET_LENGTH + " correct";
        TextView textView = findViewById(R.id.number_correct);
        textView.setText(result);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void finishButton(View view) {
        finish();
    }
}