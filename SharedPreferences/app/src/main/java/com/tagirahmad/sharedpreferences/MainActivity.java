package com.tagirahmad.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText userMessage;
    Button counter;
    CheckBox remember;

    int count = 0;
    String name;
    String message;
    boolean isChecked;

    SharedPreferences sharedPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        userMessage = findViewById(R.id.userMessage);
        counter = findViewById(R.id.counter);
        remember = findViewById(R.id.remember);

        counter.setOnClickListener(v -> {
            count = count + 1;
            counter.setText("" + count);
        });

        retrieveData();
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    public void saveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        isChecked = remember.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("key name", name);
        editor.putString("key message", message);
        editor.putInt("key count", count);
        editor.putBoolean("key remember", isChecked);
        editor.apply();

        Toast.makeText(getApplicationContext(), "Your data is saved", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    public void retrieveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);

        name = sharedPreferences.getString("key name", null);
        message = sharedPreferences.getString("key message", null);
        count = sharedPreferences.getInt("key count", 0);
        isChecked = sharedPreferences.getBoolean("key remember", false);

        userName.setText(name);
        userMessage.setText(message);
        counter.setText("" + count);
        remember.setChecked(isChecked);
    }
}