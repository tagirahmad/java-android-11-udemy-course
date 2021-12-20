package com.tagirahmad.applicationlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView counterTextView;
    Button incrementButton;
    Button navigateButton;

    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counter);
        incrementButton = findViewById(R.id.increment);
        navigateButton = findViewById(R.id.navigate);

        incrementButton.setOnClickListener(v -> {
            counter = counter + 1;
            counterTextView.setText(counter.toString());
        });

        navigateButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
        });

        Log.d("Message", "First Activity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "First Activity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "First Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "First Activity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message", "First Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "First Activity onResume");
    }
}