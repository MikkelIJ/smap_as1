package com.mikkel.mikkeljensen_au529152_fall_assignment1.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikkel.mikkeljensen_au529152_fall_assignment1.Animalitem;
import com.mikkel.mikkeljensen_au529152_fall_assignment1.R;

import java.util.ArrayList;

public class AnimalAdaptorRV extends RecyclerView.Adapter<AnimalAdaptorRV.AnimalViewHolder> {
    private Context mContext;

    private ArrayList<Animalitem> mAnimalList;
    public static class AnimalViewHolder extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextviewWord;
        public TextView mTextviewPronounced;
        public TextView mTextviewRating;


        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextviewWord = itemView.findViewById(R.id.txtWord);
            mTextviewPronounced = itemView.findViewById(R.id.txtPronounced);
            mTextviewRating = itemView.findViewById(R.id.txtRating);
        }
    }

    public AnimalAdaptorRV(Context context, ArrayList<Animalitem> animalList){
        this.mAnimalList = animalList;
        this.mContext = context;

    }

    //source https://www.youtube.com/watch?v=17NbUcEts9c&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4&index=2 6:00
    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
        AnimalViewHolder animalViewHolder = new AnimalViewHolder(v);
        return animalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animalitem currentAnimal = mAnimalList.get(position);
        holder.mImageView.setImageResource(currentAnimal.getmImageResource());
        holder.mTextviewWord.setText(currentAnimal.getmWord());
        holder.mTextviewPronounced.setText(currentAnimal.getmPronounced());
        holder.mTextviewRating.setText(currentAnimal.getmRating());
    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
