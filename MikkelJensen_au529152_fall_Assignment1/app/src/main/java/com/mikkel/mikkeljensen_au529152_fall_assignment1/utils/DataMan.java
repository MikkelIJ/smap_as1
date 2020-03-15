package com.mikkel.mikkeljensen_au529152_fall_assignment1.utils;

import android.content.Context;
import android.util.Log;

import com.mikkel.mikkeljensen_au529152_fall_assignment1.Animalitem;
import com.mikkel.mikkeljensen_au529152_fall_assignment1.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class DataMan {
    private Context context;

    public DataMan(Context context) {
        this.context = context;
    }


    // inspiration to set image from drawable https://stackoverflow.com/questions/11737607/how-to-set-the-image-from-drawable-dynamically-in-android

    private int setImageFromDrawable(String word){
        int res = context.getResources().getIdentifier(word,"drawable",context.getPackageName());
        return res;
    }

    // inspired csv import source https://www.youtube.com/watch?v=i-TqNzUryn8
    public ArrayList<Animalitem> addData(){
        ArrayList<Animalitem> animalList = new ArrayList<>();
        //add data from csv file
        InputStream is = context.getResources().openRawResource(R.raw.animal_list);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;
        try {
            while ((line = reader.readLine()) != null){
                String[] token = line.split(";");
                String animalWord = token[0];
                String animalPronounced = token[1];
                String animalDescription = token[2];
                Animalitem animal = new Animalitem(animalWord,animalPronounced,animalDescription);
                animal.setmRating("X.X");
                //int resId = getResources().getIdentifier(animal.getmWord().toLowerCase(), "drawable", this.getPackageName());
                Log.wtf("hvadnu",token[0].toLowerCase());
                animal.setmImageResource(setImageFromDrawable(animal.getmWord().toLowerCase()));
                animalList.add(animal);

            }
                return animalList;
        }
        catch (IOException e){
            Log.wtf("ListActivity","Error. could not read file on line", e);
            e.printStackTrace();
        }
        return null;
    }
}
