package com.example.flashcard.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashcard.R;
import com.example.flashcard.dao.ItemMainDao;

import java.util.ArrayList;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    private ArrayList<ItemMainDao> localDataSet;

    public AdapterMain(ArrayList<ItemMainDao> dataSet) {
        this.localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deck_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(localDataSet.get(position).getTextInfo());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageview;
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textview);
            imageview = (ImageView) view.findViewById(R.id.imageview);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView imageView() {
            return imageview;
        }
    }
}
