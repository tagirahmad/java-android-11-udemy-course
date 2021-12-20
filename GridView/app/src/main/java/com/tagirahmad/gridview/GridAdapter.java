package com.tagirahmad.gridview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private final ArrayList<String> text;
    private final ArrayList<Integer> image;

    public GridAdapter(ArrayList<String> text, ArrayList<Integer> image) {
        this.text = text;
        this.image = image;
    }

    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.gridview_layout, parent, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        textView.setText(text.get(position));
        imageView.setImageResource(image.get(position));

        return view;
    }
}
