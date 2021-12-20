package com.tagirahmad.recycleviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CoutryViewHolder> {
    public RecyclerAdapter(ArrayList<String> countryNameList, ArrayList<String> detailsList, ArrayList<Integer> imageList, Context context) {
        this.countryNameList = countryNameList;
        this.detailsList = detailsList;
        this.imageList = imageList;
        this.context = context;
    }

    private final ArrayList<String> countryNameList;
    private final ArrayList<String> detailsList;
    private final ArrayList<Integer> imageList;
    private final Context context;

    @NonNull
    @NotNull
    @Override
    public CoutryViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new CoutryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerAdapter.CoutryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryNameList.get(position));
        holder.textViewDetails.setText(detailsList.get(position));
        holder.imageView.setImageResource(imageList.get(position));
        holder.cardView.setOnClickListener(v -> {
            if (position == 0) {
                Toast.makeText(context, "You selected the United Kingdom Flag", Toast.LENGTH_SHORT).show();

            } else if (position == 1) {
                Toast.makeText(context, "You selected Germany Flag", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "You selected USA Flag", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryNameList.size();
    }


    public static class CoutryViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewCountryName;
        private final TextView textViewDetails;
        private final ImageView imageView;
        private final CardView cardView;

        public CoutryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewDetails = itemView.findViewById(R.id.textViewDetail);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
