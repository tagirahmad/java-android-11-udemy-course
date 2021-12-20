package com.tagirahmad.applicationlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
            // Go back with intent
            // Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            // startActivity(intent);

            // Go back with finishing current activity
            finish();
        });

        Log.d("Message", "Second Activity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "Second Activity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "Second Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "Second Activity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message", "Second Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "Second Activity onResume");
    }
}