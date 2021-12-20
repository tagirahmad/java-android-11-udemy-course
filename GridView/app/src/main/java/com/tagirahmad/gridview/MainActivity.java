package com.tagirahmad.gridview;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        fillArray();

        GridAdapter gridAdapter = new GridAdapter(text, image);

        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(
                getApplicationContext(),
                "You selected " + text.get(position),
                Toast.LENGTH_SHORT
        ).show());
    }

    public void fillArray() {
        text.add("Bird");
        text.add("Cat");
        text.add("Chicken");
        text.add("Dog");
        text.add("Fish");
        text.add("Monkey");
        text.add("Rabbit");
        text.add("Sheep");
        text.add("Lion");

        image.add(R.drawable.bird);
        image.add(R.drawable.cat);
        image.add(R.drawable.chicken);
        image.add(R.drawable.dog);
        image.add(R.drawable.fish);
        image.add(R.drawable.monkey);
        image.add(R.drawable.rabbit);
        image.add(R.drawable.sheep);
        image.add(R.drawable.lion);
    }
}