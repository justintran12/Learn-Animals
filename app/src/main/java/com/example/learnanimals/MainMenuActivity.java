package com.example.learnanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "start";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView textview = findViewById(R.id.textView2);
        textview.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void startEasyButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "easy");
        startActivity(intent);
    }

    public void startHardButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "hard");
        startActivity(intent);
    }
}