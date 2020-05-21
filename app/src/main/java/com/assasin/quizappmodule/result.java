package com.assasin.quizappmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreText = findViewById(R.id.score_text);

        String value = getIntent().getStringExtra("Score");

        scoreText.setText("Your score is: " + value);

    }
}
